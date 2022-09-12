package servlet;

import lombok.SneakyThrows;
import manager.BookManager;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private BookManager bookManager = new BookManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> bookList = null;
        try {
            bookList = bookManager.getAllBook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("book", bookList);
        req.getRequestDispatcher("/WEB-INF/book.jsp").forward(req, resp);

    }

}
