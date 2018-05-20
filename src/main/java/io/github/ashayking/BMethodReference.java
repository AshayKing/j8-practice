package io.github.ashayking;

import io.github.ashayking.model.Employee;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class BMethodReference {

	interface IEmployee {
		boolean check(Employee e);
	}

	private void checkPost(IEmployee iemployee, Employee employee) {
		boolean res = iemployee.check(employee);
		System.out.println("Result : " + res);
	}

	public static void main(String[] args) {
		BMethodReference caller = new BMethodReference();

		Employee executive = new Employee();
		executive.setId(1);
		executive.setName("John");
		executive.setExecutive(true);
		executive.setDepartment("CODING");

		// Inner class
		caller.checkPost(new IEmployee() {
			@Override
			public boolean check(Employee t) {
				return t.isExecutive();
			}
		}, executive);

		// Lambda Expression
		caller.checkPost(t -> t.isExecutive(), executive);

		// Method reference
		caller.checkPost(Employee::isExecutive, executive);
	}
}
