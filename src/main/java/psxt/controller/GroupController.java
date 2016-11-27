package psxt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.globalInfo.ResponseCode;
import psxt.handler.GroupHandler;
import psxt.mode.ResponseMessage;
import psxt.myutil.HTMLToWord;

@Controller
public class GroupController {

	
	@Autowired
	GroupHandler groupHandler;
	
	@Autowired
	private Environment env;
	
	//生成指定组数的分组
	@RequestMapping("/psxt/createGroup")
	@ResponseBody
	public ResponseMessage createGroup(@RequestParam String groupNum) {
		return groupHandler.createGroup(groupNum);
	}


	
	//生成结果导出文件
	@RequestMapping("/psxt/sendhtmlcontent")
	@ResponseBody
	public ResponseMessage createDoc(@RequestParam String htmlContent){
		ResponseMessage response = new ResponseMessage();
		try{
			String rootPath = env.getProperty("rootPath");
			String fileName = System.currentTimeMillis()+".doc";
			HTMLToWord.createWord(rootPath,fileName,htmlContent);
			System.out.println("fdsfdsfgde"+fileName);
			response.setCode(ResponseCode.SUCCESS.ordinal());
			response.setMessage(fileName);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			response.setCode(ResponseCode.FAILED.ordinal());
			response.setMessage("生成word文档失败");
		}
		
		return response;
	}
	
}
