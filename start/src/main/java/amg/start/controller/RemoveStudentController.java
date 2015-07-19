//package amg.start.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import amg.start.service.StudentService;
//
//@Controller
//public class RemoveStudentController {
//
//	@Autowired
//	private StudentService studentService;
//
//	@RequestMapping(value = "student/remove/{id}")
//	public String editStudent(@PathVariable(value = "id") long studentId) {
//
//		studentService.removeStudent(studentId);
//
//		return "redirect:/viewStudent";
//
//	}
//
//}
