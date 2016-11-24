package psxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.globalInfo.SessionKey;
import psxt.handler.LoginHandler;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Controller
public class UserController {
    
	@Autowired
	private LoginHandler loginHandler;
	
    @RequestMapping("/psxt/login") 
    @ResponseBody
    public ResponseMessage login(HttpSession session,@RequestParam String userName,@RequestParam String password) {
    	return loginHandler.tryLogin(session,userName, password);
    }
    
	@RequestMapping("/psxt/getuserinfo")
	@ResponseBody
	public User getUserInfo(HttpSession session){
		User user = (User) session.getAttribute(SessionKey.USERNAME.name());
		return user;
	}

}
