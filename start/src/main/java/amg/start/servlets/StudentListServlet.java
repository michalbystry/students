package amg.start.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.start.model.Student;
import amg.start.service.StudentService;
import amg.start.service.StudentServiceImpl;

public class StudentListServlet extends HttpServlet {


	private static final String VIEW_PATH = "/WEB-INF/jsp/student/student-list.jsp";
	private static final String STUDENTS = "students";

	private StudentService studentService;

	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		List <Student> students = studentService.getStudentList();
		request.setAttribute(STUDENTS, students);
		
		request.getRequestDispatcher(VIEW_PATH).forward(request, response);
		
		

	}

}