package com.examples.javatest.movies.service;

import com.examples.javatest.movies.data.MovieRepository;
import com.examples.javatest.movies.model.Genre;
import com.examples.javatest.movies.model.Movie;
import java.util.stream.Collectors;
import java.util.Collection;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }
}


