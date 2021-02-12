package by.epam.grovs.servlet.servlet;

import by.epam.grovs.servlet.dto.FilmDto;
import by.epam.grovs.servlet.entity.Film;
import by.epam.grovs.servlet.service.FilmService;
import by.epam.grovs.servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/filmDto")
public class FilmDtoServlet extends HttpServlet {
    FilmService filmService = FilmService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Film film = filmService.getByFilmId(Long.valueOf(id)).get();

        req.setAttribute("film", film);

        req.getServletContext()
                .getRequestDispatcher(JspPath.get("film"))
                .forward(req, resp);

    }
}
