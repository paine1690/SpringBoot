package hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import psxt.globalInfo.SessionKey;
import psxt.mode.User;

public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor>>>>>"+request.getRequestURI());
        if(request.getRequestURI().equals("/psxt")||request.getRequestURI().equals("/psxt/login")
        		||request.getRequestURI().equals("/psxt/superadmin")
        		||request.getRequestURI().equals("/psxt/schooladmin")
        		||request.getRequestURI().equals("/psxt/teacheradmin")){
        	return true;
        }
        
        User user = (User) request.getSession().getAttribute(SessionKey.USERNAME.name());
        if(user==null||user.getRole()==0){
        	response.sendRedirect(request.getContextPath() + "/psxt302");
        	return false;
        }
        
        return true;
    }



}
