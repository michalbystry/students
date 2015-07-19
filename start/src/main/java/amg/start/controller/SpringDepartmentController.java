package amg.start.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import amg.start.model.Department;
import amg.start.model.SearchCriteria;
import amg.start.service.DepartmentService;

@Controller
public class SpringDepartmentController {

	private static final Logger logger = LoggerFactory.getLogger(SpringDepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "viewDepartment", method = RequestMethod.GET)
	public ModelAndView viewDepartments(Model model) {

		Map<String, List<Department>> departments = new HashMap<String, List<Department>>();

		departments.put("departments", departmentService.getDepartmentList());

		return new ModelAndView("departmentList", departments);
	}

	@RequestMapping(value = "/searchDepartment", method = RequestMethod.GET)
	public ModelAndView searchDepartment(Model model) {

		SearchCriteria criteria = new SearchCriteria();
		criteria.setId(-1);

		return new ModelAndView("searchDepartment", "searchCriteria", criteria);
	}

	@RequestMapping(value = "/searchDepartment", method = RequestMethod.POST)
	public ModelAndView showDepartment(@ModelAttribute SearchCriteria criteria, BindingResult bindingResult) {

		long id = criteria.getId();

		// VALIDATOR
		if (id != -1 && departmentService.searchDepartment(id) != null) {
			Department searchedDepartment = departmentService.searchDepartment(id);

			return new ModelAndView("printDepartment", "department", searchedDepartment);

		}

		return new ModelAndView("searchDepartment");

	}

	@RequestMapping(value = "/printDepartment", method = RequestMethod.GET)
	public ModelAndView printDepartment(Model model) {

		return new ModelAndView("printDepartment");
	}

	// @RequestMapping(value = "department/edit", method = RequestMethod.GET)
	// public ModelAndView editDepartment(@RequestParam(value = "id", required =
	// false) String departmentId) {
	//
	// if (departmentId == null) {
	//
	// return new ModelAndView("editDepartment", "departmentObject",
	// departmentService.getNewDepartment());
	//
	// }
	//
	// long id = Long.valueOf(departmentId);
	// Department editedDepartment = departmentService.searchDepartment(id);
	//
	// // sprawdzanie ID departmentu
	// if (editedDepartment != null) {
	//
	// return new ModelAndView("editDepartment", "departmentObject",
	// editedDepartment);
	//
	// } else {
	// return new ModelAndView("editDepartment", "departmentObject",
	// departmentService.getNewDepartment());
	// }
	// }

	@RequestMapping(value = "department/edit", method = RequestMethod.GET)
	public String editDepartment(@RequestParam(value = "id", required = false) String departmentId, Model model) {

		if (departmentId == null) {

			model.addAttribute("departmentObject", departmentService.getNewDepartment());
			return "editDepartment";

		}

		long id = Long.valueOf(departmentId);
		Department editedDepartment = departmentService.searchDepartment(id);

		// sprawdzanie ID departmentu
		if (editedDepartment != null) {

			model.addAttribute("departmentObject", editedDepartment);
			return "editDepartment";

		} else {
			return "editDepartment";
		}
	}

	@RequestMapping(value = "department/edit", method = RequestMethod.POST)
	public String submitEditedDepartment(@Valid Department departmentObject,
			BindingResult result, @RequestParam(value = "id", required = false) String id) {

		// TODO: sprawdzic dodanie countera tylko w momencie wywolania metody
		// addDepartment

		// Jezeli pola nieprawdidlowo wypelnione to zaladuj ponownie formularz,
		// jestli prawidlowo to dodaj lub edytuj departament
		if (result.hasErrors()) {

			logger.info("ponowne wyswietlenie formularza");
System.out.println("blad formularza");
			return "redirect:/department/edit";
		}

		else {

			if (id == null) {
				departmentService.addDepartment(departmentObject);

				return "redirect:/viewDepartment";
			}

			long searchedID = Long.parseLong(id);

			Department searchedDepartment = departmentService.searchDepartment(searchedID);

			if (searchedDepartment != null) {
				departmentService.editDepartmentInCollection(searchedID, departmentObject.getName());

			} else {
				departmentService.addDepartment(departmentObject);
			}

			return "redirect:/viewDepartment";

		}
	}
	
	
	
//	@RequestMapping(value = "department/edit", method = RequestMethod.POST)
//	public String submitEditedDepartment(@Valid @ModelAttribute("editedDepartment")  Department editedDepartment,
//			BindingResult result, @RequestParam(value = "id", required = false) String id) {
//
//		// TODO: sprawdzic dodanie countera tylko w momencie wywolania metody
//		// addDepartment
//
//		// Jezeli pola nieprawdidlowo wypelnione to zaladuj ponownie formularz,
//		// jestli prawidlowo to dodaj lub edytuj departament
//		if (result.hasErrors()) {
//
//			logger.info("ponowne wyswietlenie formularza");
//
//			return "redirect:/department/edit";
//		}
//
//		else {
//
//			if (id == null) {
//				departmentService.addDepartment(editedDepartment);
//
//				return "redirect:/viewDepartment";
//			}
//
//			long searchedID = Long.parseLong(id);
//
//			Department searchedDepartment = departmentService.searchDepartment(searchedID);
//
//			if (searchedDepartment != null) {
//				departmentService.editDepartmentInCollection(searchedID, editedDepartment.getName());
//
//			} else {
//				departmentService.addDepartment(editedDepartment);
//			}
//
//			return "redirect:/viewDepartment";
//
//		}
//	}

	@RequestMapping(value = "department/remove/{id}")
	public String editDepartment(@PathVariable(value = "id") long departmentId) {

		departmentService.removeDepartment(departmentId);

		return "redirect:/viewDepartment";

	}

}
