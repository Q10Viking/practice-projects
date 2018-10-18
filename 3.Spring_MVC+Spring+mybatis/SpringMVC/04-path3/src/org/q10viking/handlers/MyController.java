package org.q10viking.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyController implements Controller {
	private static int count = 0;
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		//底层执行的是request.setAttribute()方法
		mv.addObject("access",++count);
		mv.setViewName("/index.jsp");
		return mv;
	}

}
