package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherAdminController {
	@RequestMapping("/psxt/teacheradmin")
	public String getTeacherAdminPage(){
		return "/psxt/teacheradmin/teacheradmin";
	}
}