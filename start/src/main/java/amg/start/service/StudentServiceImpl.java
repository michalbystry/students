package amg.start.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import amg.start.model.Student;

@Service(value="studentService")
public class StudentServiceImpl implements StudentService {

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	// mock students
	private static List<Student> students;
	
	private static int index = 0;

	static {
		students = new ArrayList<Student>();
		students.add(new Student(index++, "Janek", "Nowak", "45353764"));
		students.add(new Student(index++, "Kamila", "Nowak", "23453"));
		students.add(new Student(index++, "Michal", "Tomaczyk", "345365"));
		students.add(new Student(index++, "Staszek", "Krym", "453564"));
	}

	public List<Student> getStudentList() {

		return students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public Student getNewStudent() {
		return new Student(index++);
	}

	public Student searchStudent(long id) {

		for (Student student : students) {
			if (student.getId() == id)
				return student;
		}

		return null; 
	}

	public void editStudentInCollection(long id, String first_name, String last_name, String pesel) {
		Student tempStudent = searchStudent(id);
		tempStudent.editStudent(first_name, last_name, pesel);
	}

	public void removeStudent(long id) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId()==id){
				students.remove(i);
			}
			
		}
		 
	}

}
