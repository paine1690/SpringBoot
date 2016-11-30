package psxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.handler.Scorehandler;
import psxt.mode.Result;
import psxt.mode.TeacherGrade;

@Controller
public class ScoreController {

	
	@Autowired
	Scorehandler scorehandler;
	
	
	//获取排名
	@RequestMapping("/psxt/getAllScore")
	@ResponseBody
	public List<Result> getAllScore() {
		return scorehandler.getAllScore();
	}
	
	
	//获取每个专家的评审情况，是否完成分配的任务
	@RequestMapping("/psxt/getTeacherGradelist")
	@ResponseBody
	public List<TeacherGrade> getTeacherGradeList(){
		//System.out.println("*******controller");
		return scorehandler.getTeacherGradeList();
	}
}
