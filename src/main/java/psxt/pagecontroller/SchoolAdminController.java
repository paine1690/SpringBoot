package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchoolAdminController {
	@RequestMapping("/psxt/schooladmin")
	public String getSchoolAdminPage(){
		return "/psxt/schooladmin/schooladmin";
	}
	
	
	
	
	
}
