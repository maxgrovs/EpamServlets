package by.epam.grovs.servlet.service;

import by.epam.grovs.servlet.dao.FilmDao;
import by.epam.grovs.servlet.entity.Film;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FilmService {

    private FilmService() {
    }

    private static final FilmService INSTANCE = new FilmService();

    public static FilmService getInstance() {
        return INSTANCE;
    }

    public Optional<Film> getByFilmId(Long id){

            return FilmDao.getInstance().findOne( id);
    }

    public Film save(Film film){

        return FilmDao.getInstance().save(film);

    }

}
