package io.github.ashayking.util;

import java.util.ArrayList;
import java.util.List;

import io.github.ashayking.model.Actor;
import io.github.ashayking.model.Movie;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class MovieUtil {
	public static List<Movie> createMovies() {

		List<Movie> movies = new ArrayList<>();

		Movie movie = new Movie("Iron Man", true, "");
		movies.add(movie);
		movie = new Movie("Incredible Hulk", true, "");
		movies.add(movie);
		movie = new Movie("Captain America", true, "");
		movies.add(movie);
		movie = new Movie("Doctor Strange", true, "");
		movies.add(movie);
		movie = new Movie("Thor", true, "Bro Russo");
		movies.add(movie);
		movie = new Movie("Avengers", true, "Joe Russo");
		movies.add(movie);
		movie = new Movie("Guardians of Galaxy", false, "Joe Russo");
		movies.add(movie);
		movie = new Movie("Infinity war", false, "Joe Russo");
		movies.add(movie);
		return movies;

	}

	public static List<Movie> createMoviesAndActors() {

		List<Movie> movies = new ArrayList<>();
		List<Actor> actors1 = new ArrayList<>();
		Actor actor = null;
		Movie movie = null;

		movie = new Movie("Iron Man");
		actor = new Actor("Robert Downey Jr.");
		actors1.add(actor);
		actor = new Actor("Terrence Howard");
		actors1.add(actor);
		actor = new Actor("Gwyneth Paltrow");
		actors1.add(actor);
		movie.setActors(actors1);

		movies.add(movie);

		List<Actor> actors2 = new ArrayList<>();
		movie = new Movie("Infinity War");
		actor = new Actor("Robert Downey Jr");
		actors2.add(actor);
		actor = new Actor("Chris Hemsworth");
		actors2.add(actor);
		actor = new Actor("Mark Ruffalo");
		actors2.add(actor);
		actor = new Actor("Benedict Cumberbatch");
		actors2.add(actor);
		actor = new Actor("Chris Evans");
		actors2.add(actor);
		actor = new Actor("Scarlett Johansson");
		actors2.add(actor);
		actor = new Actor("Tom Holland");
		actors2.add(actor);
		actor = new Actor("Elizabeth Olsen");
		actors2.add(actor);
		actor = new Actor("Chris Pratt");
		actors2.add(actor);
		actor = new Actor("Josh Brolin");
		actors2.add(actor);
		actor = new Actor("Dave Bautista");
		actors2.add(actor);
		actor = new Actor("Paul Bettany");
		actors2.add(actor);
		movie.setActors(actors2);

		movies.add(movie);

		return movies;

	}

}
