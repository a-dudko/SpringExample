package by.bsu.fpmi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final String HTML = "<html><head><title>Hello</title></head><body>" +
            "<h1>Hello%s!!</h1>" +
            "<p>Response to %s request</p>"+
            "</body></html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        response.getWriter().write(
                String.format(HTML, getSafeName(name), "GET"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        response.getWriter().write(
                String.format(HTML, getSafeName(name), "POST"));
    }

    private String getSafeName(String name) {
        return (name == null) ? "" : ' ' + name;

    }
}
