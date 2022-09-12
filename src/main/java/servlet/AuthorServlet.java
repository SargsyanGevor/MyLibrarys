package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {

    AuthorManager authorManager = new AuthorManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Author> authorList = authorManager.getAllAuthor();
            req.setAttribute("author", authorList);
            req.getRequestDispatcher("/WEB-INF/author.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
