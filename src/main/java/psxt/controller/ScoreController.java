package psxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.handler.Scorehandler;
import psxt.mode.Result;

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
}
