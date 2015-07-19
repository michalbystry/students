package amg.start.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amg.start.model.Student;
import amg.start.service.StudentService;
import amg.start.service.StudentServiceImpl;

public class StudentEditServlet extends HttpServlet {

	private StudentService studentService;

	private static final String VIEW_PATH = "/WEB-INF/jsp/student/student-edit.jsp";
	private static final String STUDENT = "editedStudent";

	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		long studentId = Long.valueOf(request.getParameter("id"));
		
		if(studentService.searchStudent(studentId)!=null){
				
			request.setAttribute(STUDENT, studentService.searchStudent(studentId));
			
			request.getRequestDispatcher(VIEW_PATH).forward(request, response);

		}
		else {
			
			response.sendRedirect("add");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// pobieranie atrybutu - ID studenta
		Long studentId =   Long.valueOf(request.getParameter("id"));
	
		//jezeli id studenta istnieje to wyswietl dane
		if(studentService.searchStudent(studentId)!=null){

			String first_name = (String) request.getParameter("first_name");
			String last_name = (String) request.getParameter("last_name");
			String pesel = (String) request.getParameter("PESEL");

			studentService.editStudentInCollection(studentId, first_name, last_name, pesel);
				
			response.sendRedirect("/start/students");	
		}
		
		//jezeli student ID nie istnieje, stworz nowego studenta
		else if(studentService.searchStudent(studentId)!=null || studentId>=studentService.getStudentList().size()){
			response.sendRedirect("start/student/add");
			
			
		}
		
	}

}
