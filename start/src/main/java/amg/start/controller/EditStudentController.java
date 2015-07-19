//package amg.start.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import amg.start.model.Student;
//import amg.start.service.StudentService;
//
//@Controller
//public class EditStudentController {
//
//	@Autowired
//	private StudentService studentService;
//
//	@RequestMapping(value = "student/edit", method = RequestMethod.GET)
//	public ModelAndView editStudent(@RequestParam("id") String studentId) {
//
//		long id = Long.valueOf(studentId);
//		Student editedStudent = studentService.searchStudent(id);
//
//		// sprawdzanie ID studenta
//		if (editedStudent != null) {
//			System.out.println("edity" + editedStudent.getId());
//
//			return new ModelAndView("studentEdit", "studentObject", editedStudent);
//
//		} else {
//			System.out.println("new student");
//			return new ModelAndView("studentEdit", "studentObject", new Student());
//		}
//	}
//
//	@RequestMapping(value = "student/edit", method = RequestMethod.POST)
//	public String submitEditedStudent(@ModelAttribute Student editedStudent, @RequestParam("id") String id) {
//
//		// long searchedID = editedStudent.getId();
//		long searchedID = Long.parseLong(id);
//
//		Student searchedStudent = studentService.searchStudent(searchedID);
//
//		if (searchedStudent != null) {
//			System.out.println("przed skopionowaniem");
//			studentService.editStudentInCollection(searchedID, editedStudent.getFirstName(),
//					editedStudent.getLastName(), editedStudent.getPesel());
//
//		} else {
//			studentService.addStudent(editedStudent);
//		}
//
//		return "redirect:/viewStudent";
//
//	}
//
//}
