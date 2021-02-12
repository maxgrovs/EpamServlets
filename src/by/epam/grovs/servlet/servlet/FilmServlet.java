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
import java.util.Optional;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {

    FilmService filmService = FilmService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String id = req.getParameter("id");

        Optional<Film> byFilmId = filmService.getByFilmId(Long.valueOf(id));

        resp.setContentType("text/html");

        byFilmId.ifPresent(film -> {
            Film film1 = byFilmId.get();

            try {
                resp.getWriter().println(film1.getName());

            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }
}
