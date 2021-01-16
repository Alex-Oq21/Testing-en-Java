package com.examples.javatest.movies.data;

import com.examples.javatest.movies.model.Genre;
import com.examples.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryjdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryjdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) values(?,?,?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }
    private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Movie(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")));
        }
    };
}
