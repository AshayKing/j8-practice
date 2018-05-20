package io.github.ashayking;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class CConstructorReference {

	class Student {

		public Student(int id) {
			System.out.println("I am created with Id : " + id);
		}

	}

	interface StudentFactory {
		public Student create(int id);
	}

	StudentFactory factoryRepLambda = (id) -> new Student(id);
	StudentFactory factoryCtorRef = Student::new;

	private void createStudent(int id) {
		Student res = factoryRepLambda.create(id);
		System.out.println("Result : " + res);
	}

	public static void main(String[] args) {
		CConstructorReference client = new CConstructorReference();
		client.createStudent(10);
	}
}
