package psxt.pagecontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import psxt.globalInfo.SessionKey;
import psxt.mode.User;

@Controller
public class TeacherAdminController {
	@RequestMapping("/psxt/teacheradmin")
	public String getTeacherAdminPage(HttpSession session){
		User user=(User) session.getAttribute(SessionKey.USERNAME.name());
		if(user==null){
			return "/psxt/login";
		}
		return "/psxt/teacheradmin/teacheradmin";
	}
	@RequestMapping("/psxt/judgeshowproject")
	public String getProjectPage(){
		return "/psxt/teacheradmin/judgeshowproject";
	}
	@RequestMapping("/psxt/gradeprojectpage")
	public String getGradeProjectPage(){
		return "/psxt/teacheradmin/gradedprojectpage";
	}
	

	
}
