package io.github.ashayking;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.ashayking.model.Actor;
import io.github.ashayking.model.Employee;
import io.github.ashayking.model.Movie;
import io.github.ashayking.util.EmployeeUtil;
import io.github.ashayking.util.MovieUtil;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class KAdvanceStreamOperations {

	private static void testGroupBy() {
		List<Employee> employees = EmployeeUtil.createDetailedEmployees();

		// Group by Department
		Map<String, List<Employee>> depWiseEmployee = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));
		System.out.println(depWiseEmployee);

		// MultiLevel GroupBy
		Map<String, Map<String, List<Employee>>> depAndCityWiseEmployee = employees.stream()
				.collect(groupingBy((Employee::getDepartment), groupingBy(Employee::getCity)));
		System.out.println(depAndCityWiseEmployee);

	}

	private static void testPartitionBy() {
		List<Employee> employees = EmployeeUtil.createDetailedEmployees();
		// Partition by isExecutive
		Map<Boolean, List<Employee>> partition = employees.stream()
				.collect(Collectors.partitioningBy(Employee::isExecutive));
		System.out.println(partition);

		// Partition with Group By
		Map<Boolean, Map<String, List<Employee>>> partitionWithGroup = employees.stream()
				.collect(Collectors.partitioningBy((Employee::isExecutive), groupingBy(Employee::getDepartment)));
		System.out.println(partitionWithGroup);
	}
	
	private static void testFlatMap() {
		List<Movie> movies = MovieUtil.createMoviesAndActors();
		Stream<Actor> actors = movies.stream()
								.flatMap(movie->movie.getActors().stream());
		actors.forEach(System.out::println);
	}


	public static void main(String[] args) {
		testGroupBy();
		System.out.println("===========");
		testPartitionBy();
		System.out.println("===========");
		testFlatMap();
		System.out.println("===========");
	}

}
