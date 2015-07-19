package amg.start.service;

import java.util.List;

import amg.start.model.Department;

public interface DepartmentService {

	public List<Department> getDepartmentList();
	
	public void addDepartment(Department s);
	
	public Department getNewDepartment();

	public Department searchDepartment(long id);
	
	public void editDepartmentInCollection(long id, String name);
	
	public void removeDepartment (long id);
	
	
}
