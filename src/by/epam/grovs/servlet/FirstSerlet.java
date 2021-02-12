package by.epam.grovs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class FirstSerlet extends HttpServlet {

    private int counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //---------------------------------------------
       /* resp.setContentType("text/plain");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Hello world!!!!!");*/
        //---------------------------------------------

        counter++;

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>" + counter + "</h1>");
    }
}
