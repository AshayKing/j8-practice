package io.github.ashayking;

import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.github.ashayking.model.Employee;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class FPrimitiveFunctions {

	// Predicates
	private static Predicate<Integer> evenNumberPredicate = x -> x % 2 == 0;
	private static IntPredicate evenNumberPrimitivePredicate = x -> x % 2 == 0;

	private static Predicate<Double> doublePredicate = x -> x > 10;
	private static DoublePredicate doublePrimitivePredicate = x -> x > 10;

	// Consumers
	private static Consumer<Integer> intConsumer = x -> System.out.println(x);
	private static IntConsumer intPrimitiveConsumer = x -> System.out.println(x);

	// Supppliers
	private static Supplier<Integer> intSupplier = () -> 10;
	private static IntSupplier intPrimitiveSupplier = () -> 10;

	// Functions
	private static Function<Integer, Employee> empFunction = (id) -> new Employee(id, "DEMO");
	private static IntFunction<Employee> empPrimitiveFunction = (id) -> new Employee(id, "DEMO");

	public static void main(String[] args) {
		int evenNum = 10;
		double number = 0;

		System.out.println(evenNumberPredicate.test(evenNum));
		System.out.println(evenNumberPrimitivePredicate.test(evenNum));

		System.out.println(doublePredicate.test(number));
		System.out.println(doublePrimitivePredicate.test(number));

		intConsumer.accept(evenNum);
		intPrimitiveConsumer.accept(evenNum);

		System.out.println(intSupplier.get());
		System.out.println(intPrimitiveSupplier.getAsInt());

		System.out.println(empFunction.apply(1));
		System.out.println(empPrimitiveFunction.apply(2));
	}
}
