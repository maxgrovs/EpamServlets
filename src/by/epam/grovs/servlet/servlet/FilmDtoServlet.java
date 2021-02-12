package by.epam.grovs.servlet.servlet;

import by.epam.grovs.servlet.dto.FilmDto;
import by.epam.grovs.servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filmDto")
public class FilmDtoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("film", FilmDto.builder()
                .id(25L)
                .name("Dogma")
                .year(2003)
                .build());

        req.getServletContext()
                .getRequestDispatcher(JspPath.get("film"))
                .forward(req, resp);

    }
}
