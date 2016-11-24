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
	
	//获取所有专家账号
	public List<User> getAllTeacherAccount(){
		return userDBService.getUsersByRole(3);
	}
	
	
	//修改账号用户名或密码
	public ResponseMessage changeNameOrPassword(int id, String userName, String password){
		return userDBService.changeNameOrPassword(id, userName, password);
	}
	
	//修改账号用户名或密码或备注
	public ResponseMessage changeNameOrPassworORemark(int id, String userName, String password, String remark){
		return userDBService.changeNameOrPassworORemark(id, userName, password, remark);
	}
	
	//新增专家用户
	public ResponseMessage addNewTeacherAccount(String userName, String password, String remark){
		return userDBService.addNewAccount(userName, password, remark, 3);		
	}
}
