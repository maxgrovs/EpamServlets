package by.epam.grovs.servlet.util;

public class JspPath {

    public static final String FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String get(String pageName) {

        return String.format(FORMAT, pageName);
    }

}


