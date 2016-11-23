package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperAdminPageController {
	@RequestMapping("/psxt/superadmin")
	public String getSuperAdminPage(){
		return "/psxt/superadmin/superadmin";
	}
	

	
	
}
