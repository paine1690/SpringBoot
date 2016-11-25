package psxt.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psxt.dbservive.UserDBService;
import psxt.globalInfo.ResponseCode;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Component
public class GroupHandler {
	
	@Autowired
	AccountManageHandler accountManageHandler;
	
	@Autowired
	private UserDBService userDBService;
	
	public ResponseMessage createGroup(String num){
		ResponseMessage re=new ResponseMessage();
		if(!isNumber(num)){
			re.setCode(ResponseCode.FAILED.ordinal());
			re.setMessage("请输入合法数字！");
		}else{
			int groupNUm=Integer.valueOf(num);	
			List<User> schoolList=accountManageHandler.getAllSchooleAccount();
			List<User> teacherlList=accountManageHandler.getAllTeacherAccount();	
			if(groupNUm>schoolList.size()||groupNUm>teacherlList.size()){
				re.setCode(ResponseCode.FAILED.ordinal());
				re.setMessage("分组太多，专家都不够用啦！");
				return re;
			}
			int cnt=0;
			for(User u: schoolList){
				int id=u.getId();
				int group=((cnt++)%groupNUm+1);
				if(!userDBService.changeGroup(id, group)){
					re.setCode(ResponseCode.FAILED.ordinal()); 
					return re;
				}
			}
			for(User u: teacherlList){
				int id=u.getId();
				int group=((cnt++)%groupNUm+1);
				if(!userDBService.changeGroup(id, group)){
					re.setCode(ResponseCode.FAILED.ordinal()); 
					return re;
				}
			}
		}
		return re;
	}
	
	
	private boolean isNumber(String num){
		if(num==null||num.length()==0){
			return false;
		}
		for(int i=0; i<num.length(); i++){
			if(!Character.isDigit(num.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
}
