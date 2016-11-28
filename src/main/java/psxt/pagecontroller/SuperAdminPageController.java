package psxt.pagecontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import psxt.globalInfo.SessionKey;
import psxt.mode.User;

@Controller
public class SuperAdminPageController {
	@RequestMapping("/psxt/superadmin")
	public String getSuperAdminPage(HttpSession session){
		
		User user=(User) session.getAttribute(SessionKey.USERNAME.name());
		if(user==null){
			return "/psxt/login";
		}
		return "/psxt/superadmin/superadmin";
	}
	
	/*
	 * 学校账户管理
	 */
	//获取学校账户页面
	@RequestMapping("/psxt/getSchoolAccountPage")
	public String getSchoolAccountPage(){
		return "/psxt/superadmin/schoolAccountPage";
	}
	
	/*
	 * 专家账户管理
	 */
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

	//获取专家账户生成页面
	@RequestMapping("/psxt/getcreateaccountpage")
	public String getcreateaccountpage(){
		return "/psxt/superadmin/createaccountpage";
	}
	
	/*
	 * 项目分配
	 */
	//获取项目分配页面
	@RequestMapping("/psxt/showGroupManagePage")
	public String showGroupManagePage(){
		return "/psxt/superadmin/groupManagePage";
	}
	
	
	//获取生成分组页面
	@RequestMapping("/psxt/getCreateGroupPage")
	public String getCreateGroupPage(){
		return "/psxt/superadmin/createGroupPage";
	}
	
	//获取学校分组页面
	@RequestMapping("/psxt/getSchoolGroupPage")
	public String getSchoolGroupPage(){
		return "/psxt/superadmin/schoolGroupPage";
	}	
	
	//获取专家分组页面
	@RequestMapping("/psxt/getTeacherGroupPage")
	public String getTeacherGroupPage(){
		return "/psxt/superadmin/teacherGroupPage";
	}
	
	/*
	 * 查看结果
	 */
	//获取查看结果页面
	@RequestMapping("/psxt/showResultPage")
	public String showResultPage(){
		return "/psxt/superadmin/resultPage";
	}
	
	
	//获取查看结果排名页面
	@RequestMapping("/psxt/showScoreResult")
	public String showScoreResult(){
		return "/psxt/superadmin/scorePage";
	}
	
	@RequestMapping("/psxt/getaccountmanagepage")
	public String getAccountManagePage(){
		return "/psxt/superadmin/accountManage";
	}
	
	@RequestMapping("/psxt/getprojectmanagepage")
	public String getProjectManagePage(){
		return "/psxt/superadmin/projectManage";
	}
	
	@RequestMapping("/psxt/shownotGradePage")
	public String shownotGradePage(){
		return "/psxt/superadmin/notGradePagebyTeacher";
	}
	
	
}
