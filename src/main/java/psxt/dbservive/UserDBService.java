package psxt.dbservive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.Data;
import psxt.globalInfo.ResponseCode;
import psxt.mapper.UserDBMapper;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Data
@Service
public class UserDBService {
	
	@Autowired
	private UserDBMapper userDBMapper;
	
	public User getUserByUserName(String userName){
		return userDBMapper.getUserByUserName(userName);
	}
	
	//获取指定身份的所有账号
	public List<User> getUsersByRole(int role){
		return userDBMapper.getUserByRole(role);
	}
	
	//修改指定id的userName和password
	public ResponseMessage changeNameOrPassword(int id, String userName, String password){
		ResponseMessage responseMessage = new ResponseMessage();
		if(userDBMapper.changeNameOrPassword(id, userName, password)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal()); 
		}else{
			responseMessage.setCode(ResponseCode.FAILED.ordinal()); 
		}
		return responseMessage;
	}
	
}
