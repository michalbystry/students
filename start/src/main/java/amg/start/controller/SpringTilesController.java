package amg.start.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import amg.start.model.SearchCriteria;
import amg.start.model.Student;
import amg.start.service.StudentService;

@Controller
@SessionAttributes({"studentObject"})
public class SpringTilesController {

	@Autowired
	@Qualifier(value="studentService")
	private StudentService studentService;

	@RequestMapping(value = "index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "viewStudent", method = RequestMethod.GET)
	public ModelAndView viewStudents(Model model) {

		Map<String, List<Student>> students = new HashMap<String, List<Student>>();

		students.put("persons", studentService.getStudentList());

		return new ModelAndView("studentList", students);
	}

	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.GET)
	public ModelAndView searchStudent(Model model) {

		SearchCriteria criteria = new SearchCriteria();
		criteria.setId(-1);

		return new ModelAndView("searchStudent", "searchCriteria", criteria);
	}

	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public ModelAndView showStudent(@ModelAttribute SearchCriteria criteria, BindingResult bindingResult) {

		long id = criteria.getId();

		// jezeli id zostalo podane oraz id studenta istnieje to przekieruj na
		// widok printStudent, jesli nie to zaladuje ponownie searchStudent

		// VALIDATOR
		if (id != -1 && studentService.searchStudent(id) != null) {
			Student searchedStudent = studentService.searchStudent(id);

			return new ModelAndView("printStudent", "student", searchedStudent);

		}

		return new ModelAndView("searchStudent");

	}

	@RequestMapping(value = "/printStudent", method = RequestMethod.GET)
	public ModelAndView printStudent(Model model) {

		return new ModelAndView("printStudent");
	}

	@RequestMapping(value = "student/edit", method = RequestMethod.GET)
	public ModelAndView editStudent(@RequestParam(value = "id", required =false) String studentId){

		if (studentId == null) {
			
			return new ModelAndView("studentEdit", "studentObject", studentService.getNewStudent());

		}

		long id = Long.valueOf(studentId);
		Student editedStudent = studentService.searchStudent(id);

		// sprawdzanie ID studenta
		if (editedStudent != null) {

			return new ModelAndView("studentEdit", "studentObject", editedStudent);

		} else {
			return new ModelAndView("studentEdit", "studentObject",studentService.getNewStudent());
		}
	}

	@RequestMapping(value = "student/edit", method = RequestMethod.POST)
	public String submitEditedStudent(@ModelAttribute Student editedStudent, @RequestParam("id") String id) {

		if (id == null) {
			studentService.addStudent(editedStudent);
			
			return "redirect:/viewStudent"; 
		}

		long searchedID = Long.parseLong(id);

		Student searchedStudent = studentService.searchStudent(searchedID);

		if (searchedStudent != null) {
			studentService.editStudentInCollection(searchedID, editedStudent.getFirstName(),
					editedStudent.getLastName(), editedStudent.getPesel());

		} else {
			studentService.addStudent(editedStudent);
		}

		return "redirect:/viewStudent";

	}

	@RequestMapping(value = "student/remove/{id}")
	public String editStudent(@PathVariable(value = "id") long studentId) {

		studentService.removeStudent(studentId);

		return "redirect:/viewStudent";

	}

}