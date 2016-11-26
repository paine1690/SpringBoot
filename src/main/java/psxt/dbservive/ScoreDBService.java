package psxt.dbservive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import psxt.globalInfo.ResponseCode;
import psxt.mapper.ScoreDBMapper;
import psxt.mode.ResponseMessage;
import psxt.mode.Score;

@Data
@Service
public class ScoreDBService {

	@Autowired
	private ScoreDBMapper scoreDBMapper;
	/**
	 * 查询该专家是否给该学校评分
	 * @param schoolId
	 * @param userId
	 * @return
	 */
	public boolean getScore(int schoolId, int userId){
		Score score;
		score = scoreDBMapper.selectScoreByUserIdAndSchoolId(schoolId, userId);
		if(score == null){
			return false;
		}
		return true;
	}
	
	public ResponseMessage inserScoreMessage(Score score){
		ResponseMessage responseMessage = new ResponseMessage();
		if(scoreDBMapper.addScore(score)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal()); 
		}
		else {
			responseMessage.setCode(ResponseCode.FAILED.ordinal()); 
		}
		return responseMessage;
	}
	
	public ResponseMessage updateScore(int score, int schoolId, int teacherId){
		ResponseMessage responseMessage = new ResponseMessage();
		if(scoreDBMapper.updateScore(score, schoolId, teacherId)){
			responseMessage.setCode(ResponseCode.SUCCESS.ordinal()); 
		}
		else {
			responseMessage.setCode(ResponseCode.FAILED.ordinal()); 
		}
		return responseMessage;
	}
}
