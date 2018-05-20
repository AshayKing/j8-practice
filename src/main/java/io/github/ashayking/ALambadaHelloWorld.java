package io.github.ashayking;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class ALambadaHelloWorld {

	@FunctionalInterface
	interface Greeting {

		String sayHello(String s);

	}

	public void testGreeting(String user, Greeting g) {
		String res = g.sayHello(user);

		System.out.println("Result : " + res);
	}

	public static void main(String[] args) {

		// Creating lambda
		// input -> body
		Greeting greetingLambda = (String s) -> "Hello," + s;
		new ALambadaHelloWorld().testGreeting("Ashay", greetingLambda);

		// Lets add more body
		Greeting greetingEmptyCheckLambda = (String s) -> !s.isEmpty() ? "Hello," + s : "Hello world";
		new ALambadaHelloWorld().testGreeting("", greetingEmptyCheckLambda);
	}

}
