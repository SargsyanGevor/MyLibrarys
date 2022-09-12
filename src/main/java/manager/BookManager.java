package manager;
import db.DBConnectionProvider;
import model.Author;
import model.Book;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookManager {

    private final Connection connection = DBConnectionProvider.getINSTANCE().getConnection();

    private AuthorManager authorManager = new AuthorManager();

    public void addBook(Book book) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("Insert into book(title, description, price, author_id) Values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getDescription());
        preparedStatement.setDouble(3, book.getPrice());
        preparedStatement.setInt(4, book.getAuthor().getId());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            book.setId(id);
        }

    }

    public List<Book> getAllBook() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
        List<Book> books = new LinkedList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setDescription(resultSet.getString("description"));
            book.setPrice(resultSet.getDouble("price"));
            int authorId = resultSet.getInt("author_id");
            Author author = authorManager.getById(authorId);
            book.setAuthor(author);
            books.add(book);
        }
        return books;
    }

    public void removeBookById(int bookId) {
        String sql = "delete from book where id = " + bookId;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getById(int id) throws SQLException {
        String sql = "select * from book  where id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if(resultSet.next()) {
            return getBookFromResultSet(resultSet);
        }
        return null;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setDescription(resultSet.getString("description"));
        book.setPrice(resultSet.getDouble("price"));
        int authorId = resultSet.getInt("author_id");
        Author author =authorManager.getById(authorId);
        book.setAuthor(author);
        return book;
    }

    public void edit(Book book) throws SQLException {

        String sql = "update book set title = ?, description = ?, price = ?, author_id = ? where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getDescription());
        preparedStatement.setDouble(3, book.getPrice());
        preparedStatement.setInt(4, book.getAuthor().getId());
        preparedStatement.setInt(5, book.getId());

        preparedStatement.executeUpdate();

    }

}
