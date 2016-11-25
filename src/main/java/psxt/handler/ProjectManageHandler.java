package psxt.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import psxt.dbservive.UserDBService;
import psxt.mode.ResponseMessage;
import psxt.mode.ScoreMessage;
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
	
	/**
	 * 返回该专家组的所有学校，以及学校的评分
	 * @return
	 */
	public List<ScoreMessage> getAllProjectOfJudge(int group, int userId) {
		List<ScoreMessage> list = userDBService.getProjectMessageListOfJudge(group, userId);
		return list;
	}
	/**
	 * 如果还没评分，则插入评分；已经评分，更改评分。
	 * @param userId
	 * @param schoolId
	 * @param score
	 * @return
	 */
	public ResponseMessage updateJudgement(int userId, int schoolId, int score){
		ResponseMessage responseMessage = new ResponseMessage();
		//先查找，能不能找到，不能，插入；能，更新
		return responseMessage;
	}
}
