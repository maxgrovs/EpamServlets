package by.epam.grovs.servlet.servlet;

import by.epam.grovs.servlet.entity.Film;
import by.epam.grovs.servlet.service.FilmService;
import by.epam.grovs.servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-film")
public class SaveFilmServlet extends HttpServlet {

    FilmService filmService = FilmService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher(JspPath.get("save-film"))
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Film film = Film.builder()
                .name(req.getParameter("name"))
                .build();

        Film save = filmService.save(film);

        resp.sendRedirect("/filmDto?id=" + film.getId());

    }
}
