package psxt.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {	

	

	
    @RequestMapping("/psxt") 
    public String getLoginPage() {
        return "/psxt/login";
    }
    
	@RequestMapping("/psxt/getshowprojectpage")
	public String getProjectShowpage(){
		return "/psxt/showallproject";
	}
	
	@RequestMapping("/psxt/getaddprojectbutton")
	public String getAddProjectPage(){
		return "/psxt/schooladmin/addproject";
	}
	@RequestMapping("/psxt/getaddprjctpage")
	public String getAddPrjctPage() {
		return "/psxt/projectmanagment/add_project";
	}
    

}
