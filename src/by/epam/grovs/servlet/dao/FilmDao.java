package by.epam.grovs.servlet.dao;

import by.epam.grovs.servlet.entity.Film;
import by.epam.grovs.servlet.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {

    private FilmDao() {
    }

    private static final FilmDao INSTANCE = new FilmDao();

    public static FilmDao getInstance() {
        return INSTANCE;
    }

    public static final String FIND_FILMS = "SELECT * FROM film_storage.film WHERE id = ?";

    public List<Film> findOne(Long id){

        List<Film> films = new ArrayList<>();

        try (Connection connection = ConnectionManager.get()) {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILMS);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Film film = Film.builder()

                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .year(resultSet.getInt("year"))
                        .build();

                films.add(film);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return films;

    }
}
