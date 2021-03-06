package com.examples.javatest.movies.service;

import com.examples.javatest.movies.data.MovieRepository;
import com.examples.javatest.movies.model.Genre;
import com.examples.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;
    @Before
    public void  setUp() throws Exception{
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Matrix", 151, Genre.ACTION),
                        new Movie(2,"Home Alone", 149, Genre.COMEDY),
                        new Movie(3,"Scream", 130, Genre.HORROR),
                        new Movie(4,"Scarry Movie", 155, Genre.COMEDY)
                )
        );
        movieService = new MovieService(movieRepository);
    }
    @Test
    public void return_movies_by_genre(){
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2,4)));
    }

    @Test
    public void return_movies_by_length(){
        Collection<Movie> movies = movieService.findMoviesByLength(150);
        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2,3)));

    }
}