package by.epam.grovs.servlet.servlet;

import by.epam.grovs.servlet.entity.Film;
import by.epam.grovs.servlet.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {

    FilmService filmService = FilmService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        List<Film> byFilmId = filmService.getByFilmId(Long.valueOf(id));

        resp.setContentType("text/html");

        for (Film film : byFilmId) {
           // resp.getWriter().printf("<h1>%d %s %d",film.getId(), film.getName(), film.getYear());
            resp.getWriter().println(film.getName());
        }

    }
}
