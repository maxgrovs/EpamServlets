package by.epam.grovs.servlet.dao;

import by.epam.grovs.servlet.entity.Film;
import by.epam.grovs.servlet.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmDao {

    private FilmDao() {
    }

    private static final FilmDao INSTANCE = new FilmDao();

    public static FilmDao getInstance() {
        return INSTANCE;
    }

    public static final String FIND_FILMS = "SELECT * FROM film_storage.film WHERE id = ?";

    public Optional<Film> findOne(Long id){

        Optional<Film> film = null;

        try (Connection connection = ConnectionManager.get()) {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILMS);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                 film = Optional.ofNullable(Film.builder()

                         .id(resultSet.getLong("id"))
                         .name(resultSet.getString("name"))
                         .year(resultSet.getInt("year"))
                         .build());


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return film;

    }
}
