package servlet;

import manager.AuthorManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/remove")
public class AuthorRemoveServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int authorId = Integer.parseInt(req.getParameter("authorId"));

        authorManager.removeAuthorById(authorId);

        resp.sendRedirect("/author");
    }
}
