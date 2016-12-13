package psxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import psxt.globalInfo.SessionKey;
import psxt.handler.AccountManageHandler;
import psxt.handler.LoginHandler;
import psxt.mode.ResponseMessage;
import psxt.mode.User;

@Controller
public class UserController {
    
	@Autowired
	private LoginHandler loginHandler;
	
	@Autowired
	private AccountManageHandler accountManageHandler;
	
    @RequestMapping("/psxt/login") 
    @ResponseBody
    public ResponseMessage login(HttpSession session,@RequestParam String userName,@RequestParam String password) {
    	return loginHandler.tryLogin(session,userName, password);
    }
    
	@RequestMapping("/psxt/getuserinfo")
	@ResponseBody
	public User getUserInfo(HttpSession session){
		User user = (User) session.getAttribute(SessionKey.USERNAME.name());
		return user;
	}
	
	@RequestMapping("/psxt/getUserInfoByUsername")
	@ResponseBody
	public User getUserByUsername(@RequestParam String userName) {
		System.err.println(userName);
		User user = accountManageHandler.getUserByUsername(userName);
		return user;
	}
    @RequestMapping("/psxt/logout") 
	public String logout(HttpSession session){
    	session.removeAttribute(SessionKey.USERNAME.name());
    	return "/psxt/login"; 
	}

}
