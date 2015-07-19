package amg.start.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import amg.start.model.Student;

public interface StudentService {

	public List<Student> getStudentList();
	
	public void addStudent(Student s);
	
	public Student getNewStudent();

	public Student searchStudent(long id);
	
	public void editStudentInCollection(long id, String name, String last_name, String pesel);
	
	public void removeStudent (long id);
	
	
	
	
}
