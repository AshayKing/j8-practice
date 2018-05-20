package io.github.ashayking;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.github.ashayking.model.Employee;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class DFunctions {

	// Predicate
	static Predicate<Employee> eligibleForBonus = (emp) -> emp.getRatings() > 10 ? true : false;

	// Consumer
	static Consumer<Employee> print = (emp) -> System.out.println("This is employee : " + emp.getName());

	// Supplier
	static Supplier<Employee> supplier = () -> new Employee(12, "Ashay");

	// Function
	static Function<String, Employee> createEmployee = (s) -> new Employee(0, s);

	public static void main(String[] args) {

		Employee executive = new Employee();
		executive.setId(1);
		executive.setName("John");
		executive.setRatings(12);

		System.out.println(eligibleForBonus.test(executive));
		print.accept(executive);

		Employee ashay = supplier.get();
		print.accept(ashay);

		Employee rajendra = createEmployee.apply("Rajendra");
		print.accept(rajendra);
	}
}
