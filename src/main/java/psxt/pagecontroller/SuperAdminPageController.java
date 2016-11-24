package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperAdminPageController {
	@RequestMapping("/psxt/superadmin")
	public String getSuperAdminPage(){
		return "/psxt/superadmin/superadmin";
	}
	
	@RequestMapping("/psxt/getSchoolAccountPage")
	public String getSchoolAccountPage(){
		return "/psxt/superadmin/schoolAccountPage";
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
