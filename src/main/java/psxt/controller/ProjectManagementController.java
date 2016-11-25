package psxt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import psxt.globalInfo.ResponseCode;
import psxt.globalInfo.SessionKey;
import psxt.handler.AttachementHandler;
import psxt.handler.ProjectManageHandler;
import lombok.extern.slf4j.Slf4j;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Controller
@Slf4j
public class ProjectManagementController {
	@Autowired
	private AttachementHandler attachementHandler;
	@Autowired
	private ProjectManageHandler projectManagementHandler;
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
	@RequestMapping(value = "/psxt/addnewproject", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage addNewProject(HttpSession session, @RequestParam("userId") int userId, @RequestParam("fileDir") String fileDir ){
		//查找出user表中的对应记录，并更改dir字段的值
		User user = (User)session.getAttribute(SessionKey.USERNAME.name());
		ResponseMessage response = new ResponseMessage();
		if(user == null){
			//没有登录的时候不能进行上传操作
			response.setCode(ResponseCode.FAILED.ordinal());
			return response;
		}
		response = projectManagementHandler.addNewProject(user.getId(), fileDir);
		
		return response;
	}
	
	
	/*
	 * 上面代码太乱，我要和它划清界限
	 */
	@RequestMapping(value="/psxt/getattachement/{filePath}")
	public ResponseEntity<InputStreamResource> getAttachement(@PathVariable String filePath,HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		System.out.println(filePath);
		return attachementHandler.getFile(request, response, filePath);
	}
	
	
	
}
