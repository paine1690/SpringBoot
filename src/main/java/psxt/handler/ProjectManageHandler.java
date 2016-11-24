package psxt.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import psxt.dbservive.UserDBService;
import psxt.mode.ResponseMessage;
import psxt.mode.User;
import lombok.extern.slf4j.Slf4j;

@Component
public class ProjectManageHandler {
	@Autowired
	private UserDBService userDBService;
	
	public ResponseMessage addNewProject(int userId, String fileDir){
		ResponseMessage response = new ResponseMessage();
		response = userDBService.updateFile(userId, fileDir);
		
		
		
		
		return response;
	}
}
