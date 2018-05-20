package io.github.ashayking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Data
@NoArgsConstructor
public class Employee {

	private int id;
	private String name;
	private String department;
	private String city;
	private Address address;
	private Manager manager;
	private boolean isExecutive;
	private boolean isSenior;
	private int ratings;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(int id, String name, String department, boolean isExec) {
		setId(id);
		setName(name);
		setDepartment(department);
		setExecutive(isExec);
	}

	public Employee(int id, String name, String department, String city) {
		setId(id);
		setName(name);
		setDepartment(department);
		setSenior(true);
		setCity(city);
	}
}
