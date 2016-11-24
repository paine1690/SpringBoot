package psxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.handler.AccountManageHandler;
import psxt.mode.ResponseMessage;
import psxt.mode.User;


@Controller
public class AccountManageController {

	@Autowired
	AccountManageHandler accountManageHandler;
	
	//获取所有学校账号
	@RequestMapping("/dcnh/getAllSchoolAccount")
	@ResponseBody
	public List<User> getAllProject() {
		System.out.println("get All school account");
		return accountManageHandler.getAllSchooleAccount();
	}
	

	//获取所有专家账号
	@RequestMapping("/dcnh/getAllTeacherAccount")
	@ResponseBody
	public List<User> getAllTeacherAccount() {
		System.out.println("get All Teacher account");
		return accountManageHandler.getAllTeacherAccount();
	}
	
	
	//修改账号用户名或密码
	@RequestMapping("/psxt/changeNameOrPassword")
	@ResponseBody
	public ResponseMessage changeNameOrPassword(@RequestParam int id, @RequestParam String userName, @RequestParam String password) {
		System.out.println("changenameorpassword: "+id+" "+userName+" "+password);
		ResponseMessage re=accountManageHandler.changeNameOrPassword(id, userName, password);
		return re;
	}
	
	//修改账号用户名或密码或备注
	@RequestMapping("/psxt/changeNameOrPassworORemark")
	@ResponseBody
	public ResponseMessage changeNameOrPassworORemark(@RequestParam int id, @RequestParam String userName, @RequestParam String password, @RequestParam String remark) {
		System.out.println("changeNameOrPassworORemark: "+id+" "+userName+" "+password+" "+remark);
		ResponseMessage re=accountManageHandler.changeNameOrPassworORemark(id, userName, password, remark);
		return re;
	}
	
	
}
