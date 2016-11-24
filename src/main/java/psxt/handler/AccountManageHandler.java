package psxt.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psxt.dbservive.UserDBService;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Component
public class AccountManageHandler {
	
	@Autowired
	private UserDBService userDBService;
	
	//获取所有学校账号
	public List<User> getAllSchooleAccount(){
		return userDBService.getUsersByRole(2);
	}
	
	//修改账号用户名或密码
	public ResponseMessage changeNameOrPassword(int id, String userName, String password){
		return userDBService.changeNameOrPassword(id, userName, password);
	}
}
