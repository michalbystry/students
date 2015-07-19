package amg.start.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.start.service.StudentService;
import amg.start.service.StudentServiceImpl;

public class StudentDeleteServlet extends HttpServlet {

//	private static final String VIEW_PATH = "/WEB-INF/jsp/student/student-list.jsp";

	private StudentService studentService;

	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Long studentId =   Long.valueOf(request.getParameter("id"));
	
		//VALIDATOR?
		
		studentService.removeStudent(studentId);
		
		response.sendRedirect("/start/students");	
	}

//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		Long studentId =   Long.valueOf(request.getParameter("id"));
//	
//		studentService.removeStudent(studentId);
//			
//		response.sendRedirect("/start/students");
//	}
}
