package net.ycod3r.interceptors;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.ycod3r.model.Employee;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger("AuthInterceptor");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//logger.info("--- Pre handle ---");
		return true;
		// return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		super.postHandle(request, response, handler, modelAndView);
		if(modelAndView.getModelMap().containsKey("emp")){
			logger.info("Employee Interceptor invoked ...");
			Employee emp = (Employee) modelAndView.getModelMap().get("emp");
			emp.setNom("NOUVEAU");
			modelAndView.getModelMap().put("emp", emp);
		}
	}
	
	

}
