package amg.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import amg.start.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static List<Department> departments;

	static {

		departments = new ArrayList<Department>();
		departments.add(new Department("Wydzial 1"));
		departments.add(new Department("Wydzial 2"));
		departments.add(new Department("Wydzial 3"));
		departments.add(new Department("Wydzial 4"));
		
	}
	
	
	public List<Department> getDepartmentList() {

		return departments;
	}

	public void addDepartment(Department s) {
		departments.add(s);
	}

	public Department getNewDepartment() {
		return new Department();
	}

	public Department searchDepartment(long id) {

		for (Department department : departments) {
			if (department.getId() == id)
				return department;
		}

		return null; 
	}

	public void editDepartmentInCollection(long id, String name) {
		Department tempDepartment = searchDepartment(id);
		tempDepartment.editDepartment(name);
	}

	public void removeDepartment(long id) {
		for (int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getId()==id){
				departments.remove(i);
			}
			
		}
		 
	}
}
