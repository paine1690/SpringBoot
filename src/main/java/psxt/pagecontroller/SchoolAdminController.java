package psxt.pagecontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import psxt.globalInfo.SessionKey;
import psxt.mode.User;

@Controller
public class SchoolAdminController {
	@RequestMapping("/psxt/schooladmin")
	public String getSchoolAdminPage(HttpSession session){
		User user=(User) session.getAttribute(SessionKey.USERNAME.name());
		if(user==null){
			return "/psxt/login";
		}
		return "/psxt/schooladmin/schooladmin";
	}
	
	@RequestMapping("/psxt/getSchoolUserInfoPage")
	public String getUserInfoPage(){
		return "/psxt/schooladmin/schoolPersonInfo";
	}
	
}
