package com.examples.javatest.movies.data;

import com.examples.javatest.movies.model.Genre;
import com.examples.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;


import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    @Test
    public void load_all_movies() throws SQLException {
        //Se crea base de datos de prueba en memoria con formato SQL
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "se", "se");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MovieRepositoryjdbc movieRepositoryjdbc = new MovieRepositoryjdbc(jdbcTemplate);
        Collection<Movie> movies = movieRepositoryjdbc.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1,"the raid redemption", 152, Genre.ACTION),
                new Movie(2,"Rapidos y furiosos", 130, Genre.ACTION),
                new Movie(3,"Scary Movie", 145, Genre.COMEDY),
                new Movie(4,"Jepper Creepers", 130, Genre.HORROR),
                new Movie(5,"La morgue", 120, Genre.THRILLER)
        )));
    }

}