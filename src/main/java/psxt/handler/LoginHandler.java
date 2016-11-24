package psxt.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psxt.dbservive.UserDBService;
import psxt.globalInfo.Href;
import psxt.globalInfo.ResponseCode;
import psxt.globalInfo.SessionKey;
import psxt.mode.User;
import psxt.mode.ResponseMessage;
import psxt.myutil.SHA256;

@Component
public class LoginHandler {
	
	@Autowired
	private UserDBService userDBService;

	public ResponseMessage tryLogin(HttpSession session,String userName,String password){
		System.out.println("loginHandler");
		ResponseMessage responseMessage = new ResponseMessage();
		User user = userDBService.getUserByUserName(userName);
		
		if(user==null){
			responseMessage.setCode(ResponseCode.FAILED.ordinal());
			responseMessage.setMessage("该用户不存在");
			return responseMessage;
		}
		String userPassword = user.getPassword();
		System.out.println("password"+userPassword+"   "+SHA256.encode(password));
		if(userPassword.equals(SHA256.encode(password))){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal());
			String href = getHref(user.getRole());
			responseMessage.setHref(href);
			responseMessage.setMessage("登录成功");
			session.setAttribute(SessionKey.USERNAME.name(), user);
		}
		else{
			responseMessage.setCode(ResponseCode.FAILED.ordinal());
			responseMessage.setMessage("登录失败，密码错误");
		}
		return responseMessage;
	}
	
	public static String getHref(int role){
		switch(role){
			case 1:{
				return Href.SUPER_ADMIN;
			}
			case 2:{
				return Href.SCHOOL_ADMIN;
			}
			case 3:{
				return Href.TEACHER_ADMIN;
			}
			default:
				return "/";
		}
	}
}
