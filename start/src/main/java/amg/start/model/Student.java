package amg.start.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student {

	private static final Logger log = LoggerFactory.getLogger(Student.class);

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	private String pesel;
	private long id;
	
	
	public Student(){
	};

	public Student(int index){
		this.id=index;
	};


	public Student(int index, String fist_name, String last_name, String pesel) {
		this.id=index;
		this.firstName = fist_name;
		this.lastName = last_name;
		this.pesel = pesel;
	}

	public static Logger getLog() {
		return log;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fist_name) {
		this.firstName = fist_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void editStudent(String first_name, String last_name, String pesel){
		this.firstName=first_name;
		this.lastName=last_name;
		this.pesel = pesel;
	}

	
	
	}
	

