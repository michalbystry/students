package amg.start.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Department {

	private long id;
	
	@NotEmpty
	@NotNull
	private String name;

	private static long counterID = 0;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String name) {
		this.name = name;
		this.id = ++counterID;
	}

	public Department() {
		this.id = ++counterID;
	}

	public void editDepartment(String name) {
		this.name = name;

	}

}
