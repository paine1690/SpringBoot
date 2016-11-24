package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperAdminPageController {
	@RequestMapping("/psxt/superadmin")
	public String getSuperAdminPage(){
		return "/psxt/superadmin/superadmin";
	}
	
	//获取学校账户页面
	@RequestMapping("/psxt/getSchoolAccountPage")
	public String getSchoolAccountPage(){
		return "/psxt/superadmin/schoolAccountPage";
	}
	

	//获取专家账户管理页面
	@RequestMapping("/psxt/showTeachermanagePage")
	public String showTeachermanagePage(){
		return "/psxt/superadmin/teachermanagePage";
	}
	
	//获取专家账户展示页面
	@RequestMapping("/psxt/getTeacherAccountPage")
	public String getTeacherAccountPage(){
		return "/psxt/superadmin/teacherAccountPage";
	}
	
	
	
	@RequestMapping("/psxt/getaccountmanagepage")
	public String getAccountManagePage(){
		return "/psxt/superadmin/accountManage";
	}
	
	@RequestMapping("/psxt/getprojectmanagepage")
	public String getProjectManagePage(){
		return "/psxt/superadmin/projectManage";
	}
	
	
}
