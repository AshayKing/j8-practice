package io.github.ashayking;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.ashayking.model.Movie;
import io.github.ashayking.model.Trade;
import io.github.ashayking.util.MovieUtil;
import io.github.ashayking.util.TradeUtil;

public class JStreamOperations {

	private static void testFilter() {
		// Get classic movies of director : Bro Russo
		List<Movie> movies = MovieUtil.createMovies();
		List<Movie> filtered = movies.stream()
								.filter(Movie::isClassic)
								.filter(movie-> movie.getDirector().equals("Bro Russo"))
								.collect(Collectors.toList());
		filtered.stream().forEach(System.out::println);
	}

	private static void testMap() {
		// Get upper case name of all movies
		List<Movie> movies = MovieUtil.createMovies();
		Set<String> moviesStr = movies.stream()
								.map(Movie::getName)
								.map(String::toUpperCase)
								.collect(Collectors.toSet());
		moviesStr.forEach(System.out::println);
	}
	
	private static void testCollect() {
		
		List<Movie> movies = MovieUtil.createMovies();
		// List
		List<Movie> listCollection = movies.stream()
				.filter(Movie::isClassic)
				.collect(Collectors.toList());
		listCollection.stream().forEach(System.out::println);
		
		// Set
		Set<String> setCollection = movies.stream()
				.filter(Movie::isClassic)
				.map(Movie::getDirector)
				.collect(Collectors.toSet());
		setCollection.stream().forEach(System.out::println);
		
		// Map
		Map<String,Movie>  mapCollection =movies.stream()
				.filter(Movie::isClassic)
				.collect(Collectors.toMap(Movie::getName, movie->movie));
		System.out.println(mapCollection);
	}
	
	private static void testDistinctAndSkipLimit() {
		List<Trade> trades = TradeUtil.createTrades();
		Stream<String> companies = trades.stream()
									.map(Trade::getInstrument)
									.distinct();
		companies.forEach(System.out::println);
		System.out.println("====");
		Stream<String> limited = trades.stream()
				.map(Trade::getInstrument)
				.distinct()
				.skip(1)
				.limit(1);
		limited.forEach(System.out::println);
	}
	
	private static void testFindBy() {
		List<Trade> trades = TradeUtil.createTrades();
		
		// FindFirst
		Optional<Trade> findFirst = trades.stream()
						.filter(Trade::isBigTrade)
						.findFirst();
		System.out.println(findFirst.get());
		
		// FindAny
		Optional<Trade> findAny = trades.stream()
				.filter(Trade::isBigTrade)
				.findAny();
		System.out.println(findAny.get());
		
		// AnyMatch
		boolean isPresent = trades.stream()
				.anyMatch(t->t.getStatus().equals("CANCEL"));
		System.out.println(isPresent);
		
		// AllMatch
		boolean isAllMatch = trades.stream()
				.allMatch(t->t.getInstrument().equals("IBM"));
		System.out.println(isAllMatch);

		// AllMatch
		boolean isNoneMatch = trades.stream()
				.noneMatch(t->t.getInstrument().equals("IBM1"));
			System.out.println(isNoneMatch);
	}
	
	
	private static void testReduce() {
		List<Trade> trades = TradeUtil.createTrades();
		
		// Reducer
		Optional<String> companyStr = trades.stream()
							.map(Trade::getInstrument)
							.reduce((a, b) -> a + ", " + b);
		System.out.println(companyStr.get());
		// Total
		Optional<Integer> sum = trades.stream()
				.map(Trade::getQuantity)
				.reduce((a, b) -> a + b);
		System.out.println(sum.get());
		int sumMethod = trades.stream()
				.mapToInt(Trade::getQuantity)
				.sum();
		System.out.println(sumMethod);
	}
	
	
	public static void main(String[] args) {
		testFilter();
		System.out.println("==============");
		testMap();
		System.out.println("==============");
		testCollect();
		System.out.println("==============");
		testDistinctAndSkipLimit();
		System.out.println("==============");
		testFindBy();
		System.out.println("==============");
		testReduce();
	}
	
}
