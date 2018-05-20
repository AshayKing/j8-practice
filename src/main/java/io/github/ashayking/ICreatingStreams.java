package io.github.ashayking;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.github.ashayking.model.Movie;
import io.github.ashayking.util.MovieUtil;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class ICreatingStreams {

	private static void emptyStream() {
		Stream<Movie> movieEmptyStream = Stream.empty();
		System.out.println("Empty Stream : " + movieEmptyStream.count());
	}

	private static void collectionStream() {
		Stream<Movie> collectionStream = MovieUtil.createMovies().stream();
		System.out.println("Collection Stream : " + collectionStream.count());
	}

	private static void primitiveStream() {
		int[] ints = new int[] { 1, 2, 3, 4, 5, 6 };
		IntStream intStream = IntStream.of(ints);
		intStream.forEach(System.out::print);
		
		double[] doubles = new double[] { 1d, 2d, 3d, 4d, 5d, 6d };
		DoubleStream doubleStream = DoubleStream.of(doubles);
		doubleStream.forEach(System.out::print);
	}

	private static void streamFromValues() {
		Stream<String> movies = Stream.of("Iron Man", "Thor", "Doctor Strange", "Captain America	");
		System.out.println("String Stream : " + movies.count());

		String[] movieArr = { "Iron Man", "Thor", "Doctor Strange", "Captain America	" };
		Stream<String> movieArrStream = Stream.of(movieArr);
		System.out.println("String Stream : " + movieArrStream.count());
	}

	public static void main(String[] args) {
		emptyStream();
		streamFromValues();
		collectionStream();
		primitiveStream();

		Stream<Movie> collectionStream = MovieUtil.createMovies().stream();
		collectionStream.forEach(System.out::println);
	}
}
