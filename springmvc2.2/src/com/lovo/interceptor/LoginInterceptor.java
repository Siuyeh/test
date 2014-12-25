package com.lovo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse resp, Object obj, Exception exc)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj, ModelAndView mav) throws Exception {
		User loginUser = (User) req.getSession().getAttribute("loginUser");
		if(loginUser.getUsername().equals("admin")){
			mav.addObject("msg", "管理员是个大水逼");
		}
	}

	/**
	 * 对请求的过滤
	 * 返回true则放行，返回false则拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Exception {
		String path = req.getServletPath();
		
		if(path.indexOf("showgoods.do")>=0){
			if(req.getSession().getAttribute("loginUser")==null){
				resp.sendRedirect("test.do");
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

}
