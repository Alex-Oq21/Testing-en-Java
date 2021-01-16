package com.examples.javatest.movies.data;

import com.examples.javatest.movies.model.Genre;
import com.examples.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;


import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryjdbc movieRepository;
    private DataSource dataSource;
    @Before
    public void setUp() throws Exception {
        //Se crea base de datos de prueba en memoria con formato SQL
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "se", "se");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository  = new MovieRepositoryjdbc(jdbcTemplate);

    }
    //Listar todas las peliculas
    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1,"the raid redemption", 152, Genre.ACTION),
                new Movie(2,"Rapidos y furiosos", 130, Genre.ACTION),
                new Movie(3,"Scary Movie", 145, Genre.COMEDY),
                new Movie(4,"Jepper Creepers", 130, Genre.HORROR),
                new Movie(5,"La morgue", 120, Genre.THRILLER)
        )));
    }
    //Buscar pelicula por id
    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Rapidos y furiosos", 130, Genre.ACTION)));
    }
    //Insertar pelicula
    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("El código no compila", 230, Genre.HORROR);
        movieRepository.saveOrUpdate(movie);
        Movie newmovie = movieRepository.findById(6);
        assertThat(newmovie, CoreMatchers.is(new Movie(6, "El código no compila", 230, Genre.HORROR)));

    }
    //Eliminar datos de la bd después de ejecutar los test
    @After
    public  void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}