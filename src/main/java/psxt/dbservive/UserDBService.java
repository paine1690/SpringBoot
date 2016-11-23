package psxt.dbservive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.Data;
import psxt.mapper.UserDBMapper;
import psxt.mode.User;

@Data
@Service
public class UserDBService {
	
	@Autowired
	private UserDBMapper userDBMapper;
	
	public User getUserByUserName(String userName){
		return userDBMapper.getUserByUserName(userName);
	}
	

}
