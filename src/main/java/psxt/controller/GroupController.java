package psxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.handler.GroupHandler;
import psxt.mode.ResponseMessage;

@Controller
public class GroupController {

	
	@Autowired
	GroupHandler groupHandler;
	
	//生成指定组数的分组
	@RequestMapping("/psxt/createGroup")
	@ResponseBody
	public ResponseMessage createGroup(@RequestParam String groupNum) {
		return groupHandler.createGroup(groupNum);
	}
	//createGroup
}
