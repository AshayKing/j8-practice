package io.github.ashayking;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import io.github.ashayking.model.Employee;
import io.github.ashayking.model.Manager;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class GBiFunctions {

	// Is mgr is emp's manager
	private static BiPredicate<Employee, Manager> empMgrPredicate = (emp, mgr) -> emp.getManager().equals(mgr) ? true
			: false;

	// Is emp is mgr's PA
	private static BiPredicate<Employee, Manager> mgrAssistentPredicate = (emp,
			mgr) -> mgr.getPersonalAssistant().equals(emp) ? true : false;

	// Is emp is PA & mgr's emp
	private static BiPredicate<Employee, Manager> isPAAndEmployee = empMgrPredicate.and(mgrAssistentPredicate);

	// Is emp is PA & mgr's emp
	private static BiPredicate<Employee, Manager> isPAOrEmployee = empMgrPredicate.or(mgrAssistentPredicate);

	// Not clause
	private static BiPredicate<Employee, Manager> notMgrPredicate = empMgrPredicate.negate();

	// BiConsumer
	private static BiConsumer<Employee, Integer> empBonusConsumer = (emp, bonus) -> System.out
			.println("Employee " + emp.getName() + " has got " + bonus + "% bonus");

	private static BiConsumer<Employee, Integer> empHikeConsumer = (emp, hike) -> System.out
			.println("Employee " + emp.getName() + " has got " + hike + "% hike");

	private static BiConsumer<Employee, Integer> empBonusAndHikeConsumer = empBonusConsumer.andThen(empHikeConsumer);

	// BiFunction
	private static BiFunction<Employee, Manager, Employee> paOfMgrsEmployeeFunction = (emp, mgr) -> emp.getManager()
			.getPersonalAssistant();

	public static void main(String[] args) {
		Employee asistent = new Employee();
		asistent.setId(1);
		asistent.setName("ASISTENT");

		Manager mgr = new Manager();
		mgr.setName("MGR");
		mgr.setPersonalAssistant(asistent);
		asistent.setManager(mgr);

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("EMP");
		emp.setManager(mgr);

		System.out.println("Is Manager ? " + empMgrPredicate.test(asistent, mgr));
		System.out.println("Is PA ? " + mgrAssistentPredicate.test(asistent, mgr));
		System.out.println("Is PA ? " + mgrAssistentPredicate.test(emp, mgr));

		System.out.println("Is PA and Employee ? " + isPAAndEmployee.test(asistent, mgr));
		System.out.println("Is PA and Employee ? " + isPAAndEmployee.test(emp, mgr));

		System.out.println("Is PA or Employee ? " + isPAOrEmployee.test(asistent, mgr));
		System.out.println("Is PA or Employee ? " + isPAOrEmployee.test(emp, mgr));

		System.out.println("Not clause ? " + notMgrPredicate.test(emp, mgr));

		empBonusConsumer.accept(asistent, 10);
		empBonusConsumer.accept(emp, 8);
		empBonusAndHikeConsumer.accept(asistent, 10);
		
		Employee pa = paOfMgrsEmployeeFunction.apply(emp, mgr);
		System.out.println(pa.getName());
	}
}
