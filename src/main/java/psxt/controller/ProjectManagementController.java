package psxt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import psxt.handler.AttachementHandler;
import lombok.extern.slf4j.Slf4j;
import psxt.mode.ResponseMessage;

@Controller
@Slf4j
public class ProjectManagementController {
	@Autowired
	private AttachementHandler attachementHandler;
	
	@RequestMapping("/psxt/uploadattachement")
	@ResponseBody
	public ResponseMessage getAttachement(@RequestParam("attachement_file") MultipartFile file) throws IOException {
		//System.out.println("##### fileName ### " + file.getName() + " original filename is " + 	file.getOriginalFilename() + file.getSize());
		ResponseMessage response = new ResponseMessage();
		String fileName = file.getOriginalFilename();
		System.out.println("filename:::"+fileName);
		//返回来的是存储的路径
		String id = attachementHandler.uploadFile(file, fileName);
		response.setMessage(id);
		return response;
	}
}
