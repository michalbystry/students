//package amg.start.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import amg.start.model.SearchCriteria;
//import amg.start.model.Student;
//import amg.start.service.StudentService;
//
//@Controller
//public class SearchStudentController {
//
//	@Autowired
//	private StudentService studentService;
//
//	// ,@RequestParam(value = "id", required = false) String id)
//	/*
//	 * Student searchedStudent;
//	 * 
//	 * if(id!=null){ searchedStudent =
//	 * studentService.searchStudent(Long.valueOf(id)); return new ModelAndView
//	 * ("printStudent", "studentObject", searchedStudent); }
//	 */
//
//	@RequestMapping(value = "/searchStudent", method = RequestMethod.GET)
//	public ModelAndView searchStudent(Model model) {
//
//		SearchCriteria criteria = new SearchCriteria();
//		criteria.setId(-1);
//
//		return new ModelAndView("searchStudent", "searchCriteria", criteria);
//	}
//
//	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
//	public ModelAndView showStudent(@ModelAttribute SearchCriteria criteria, BindingResult bindingResult) {
//
//		long id = criteria.getId();
//
//		// jezeli id zostalo podane oraz id studenta istnieje to przekieruj na
//		// widok printStudent, jesli nie to zaladuje ponownie searchStudent
//		
//		
//		//VALIDATOR
//		if (id != -1 && studentService.searchStudent(id) != null) {
//			Student searchedStudent = studentService.searchStudent(id);
//
//			return new ModelAndView("printStudent", "student", searchedStudent);
//
//		}
//
//		return new ModelAndView("searchStudent");
//
//	}
//	
//	@RequestMapping(value="/printStudent", method= RequestMethod.GET)
//	public ModelAndView printStudent (Model model){
//		
//		return new ModelAndView("printStudent");
//	}
//}
