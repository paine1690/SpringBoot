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
	
	//修改指定id的userName和password和remark
	public ResponseMessage changeNameOrPassworORemark(int id, String userName, String password, String remark){
		ResponseMessage responseMessage = new ResponseMessage();
		if(userDBMapper.changeNameOrPassworORemark(id, userName, password, remark)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal()); 
		}else{
			responseMessage.setCode(ResponseCode.FAILED.ordinal()); 
		}
		return responseMessage;
	}
	
	//新增一个账户,指定用户名、密码、备注、身份
	public ResponseMessage addNewAccount(String userName, String password, String remark, int role){
		ResponseMessage responseMessage = new ResponseMessage();
		if(userDBMapper.addNewAccount(userName, password, remark, role)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal()); 
		}else{
			responseMessage.setCode(ResponseCode.FAILED.ordinal()); 
		}
		return responseMessage;
	}
	
	/**
	 * 上传或者更新文件路径
	 * @param userId
	 * @param fileDir
	 * @return
	 */
	public ResponseMessage updateFile(int userId, String fileDir){
		ResponseMessage responseMessage = new ResponseMessage();
		if(userDBMapper.updateFileDirByUserId(fileDir, userId)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal());
		}
		else {
			responseMessage.setCode(ResponseCode.FAILED.ordinal());
		}
		return responseMessage;
	}
	
}
