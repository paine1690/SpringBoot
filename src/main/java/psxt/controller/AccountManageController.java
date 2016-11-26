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
	@RequestMapping("/psxt/getAllSchoolAccount")
	@ResponseBody
	public List<User> getAllProject() {
		return accountManageHandler.getAllSchooleAccount();
	}
	
	//获取所有学校账号，按分组排序
	@RequestMapping("/psxt/showAllSchoolGroup")
	@ResponseBody
	public List<User> showAllSchoolGroup() {
		System.out.println("showAllSchoolGroup");
		return accountManageHandler.getAllAccountByGroup(2);
	}
	

	//获取所有专家账号
	@RequestMapping("/psxt/getAllTeacherAccount")
	@ResponseBody
	public List<User> getAllTeacherAccount() {
		return accountManageHandler.getAllTeacherAccount();
	}


	//获取所有学校账号，按分组排序
	@RequestMapping("/psxt/showAllTeacherGroup")
	@ResponseBody
	public List<User> showAllTeacherGroup() {
		System.out.println("showAllTeacherGroup");
		return accountManageHandler.getAllAccountByGroup(3);
	}
	
	
	
	//修改账号用户名或密码
	@RequestMapping("/psxt/changeNameOrPassword")
	@ResponseBody
	public ResponseMessage changeNameOrPassword(@RequestParam int id, @RequestParam String userName, @RequestParam String password) {
		System.out.println("changenameorpassword: "+id+" "+userName+" "+password);
		ResponseMessage re=accountManageHandler.changeNameOrPassword(id, userName, password);
		return re;
	}
	
	//修改账号用户名或密码或学校
	@RequestMapping("/psxt/changeNameOrPassworORSchool")
	@ResponseBody
	public ResponseMessage changeNameOrPassworORSchool(@RequestParam int id, @RequestParam String userName, @RequestParam String password, @RequestParam String school) {
		System.out.println("changeNameOrPassworORSchool: "+id+" "+userName+" "+password+" "+school);
		ResponseMessage re=accountManageHandler.changeNameOrPassworORSchool(id, userName, password, school);
		return re;
	}
	
	
	//新增专家用户
	@RequestMapping("/psxt/addNewTeacherAccount")
	@ResponseBody
	public ResponseMessage addNewTeacherAccount(@RequestParam String userName, @RequestParam String password, @RequestParam String school) {
		System.out.println("changeNameOrPassworORemark: "+userName+" "+password+" "+school);
		return accountManageHandler.addNewTeacherAccount(userName, password, school);
	}
	
}
