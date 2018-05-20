package io.github.ashayking;

import java.util.function.Function;

import io.github.ashayking.model.Employee;
import io.github.ashayking.model.Manager;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class EFunctionCollaboration {

	static Function<Employee, Manager> managerFinder = (emp) -> getManager(emp);
	static Function<Manager, Employee> asistantFinder = (mgr) -> getPersonalAsistsnt(mgr);

	private static Manager getManager(Employee emp) {
		return emp.getManager();
	}

	private static Employee getPersonalAsistsnt(Manager mgr) {
		return mgr.getPersonalAssistant();
	}

	// AndThen
	private static void testAndThen(Employee emp) {
		Function<Employee, Employee> employeeManagerAsistentFinder = managerFinder.andThen(asistantFinder);
		Employee asistent = employeeManagerAsistentFinder.apply(emp);
		System.out.println(asistent.getName());
	}

	// compose
	private static void testCompose(Employee emp) {
		Function<Employee, Employee> employeeManagerAsistentFinder = asistantFinder.compose(managerFinder);
		Employee asistent = employeeManagerAsistentFinder.apply(emp);
		System.out.println(asistent.getName());
	}

	public static void main(String[] args) {
		Employee asistent = new Employee();
		asistent.setName("ASISTENT");
		asistent.setId(1);

		Manager mgr = new Manager();
		mgr.setName("MGR");
		mgr.setPersonalAssistant(asistent);
		
		Employee emp = new Employee();
		emp.setId(2);
		emp.setManager(mgr);
		
		testAndThen(emp);
		testCompose(emp);
	}
}
