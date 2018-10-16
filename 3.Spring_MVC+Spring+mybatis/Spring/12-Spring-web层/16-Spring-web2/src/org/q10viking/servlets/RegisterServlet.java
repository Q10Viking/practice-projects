package org.q10viking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.q10viking.beans.Student;
import org.q10viking.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Student student = new Student(name,age);
		
		//获取到Spring容器
		/*		
		//方式一
		String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
		WebApplicationContext ac = (WebApplicationContext) this.getServletContext().getAttribute(key);
		//ApplicationContext ac = (ApplicationContext) this.getServletContext().getAttribute(key);
		*/
		
		//方式二
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		
		
		System.out.println(ac);
		
		//获取到service
		IStudentService service = (IStudentService)ac.getBean("studentService");
		
		//调用service的添加学生到数据库
		service.addStudent(student);
		
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
