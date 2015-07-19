package amg.start.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.start.model.Student;
import amg.start.service.StudentService;
import amg.start.service.StudentServiceImpl;

public class StudentAddServlet extends HttpServlet {


	private static final String VIEW_PATH = "/WEB-INF/jsp/student/student-edit-add.jsp";

	private StudentService studentService;

	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		request.getRequestDispatcher(VIEW_PATH).forward(request, response);


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String studentName = request.getParameter("first_name");
		String studentSurname = request.getParameter("last_name");
		String pesel = request.getParameter("PESEL");
	

		Student newStudent = studentService.getNewStudent();
		newStudent.setFirstName(studentName);
		newStudent.setLastName(studentSurname);
		newStudent.setPesel(pesel);
		
		studentService.addStudent(newStudent);
		
		response.sendRedirect("/start/students");

	}
}
