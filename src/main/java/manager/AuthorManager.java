package manager;

import db.DBConnectionProvider;
import model.Author;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorManager {

    private Connection connection = DBConnectionProvider.getINSTANCE().getConnection();

    public void addAuthor(Author author) {
        String sql = "insert into author(name,surname,email,age) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.setString(3, author.getEmail());
            ps.setInt(4, author.getAge());

            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                author.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAllAuthor() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM author");
        List<Author> authors = new LinkedList<>();
        while (resultSet.next()) {
            Author author = new Author();
            author.setId(resultSet.getInt("id"));
            author.setName(resultSet.getString("name"));
            author.setSurname(resultSet.getString("surname"));
            author.setEmail(resultSet.getString("email"));
            author.setAge(resultSet.getInt("age"));


            authors.add(author);
        }
        return authors;
    }

    public Author getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM author WHERE id = " + id);

        if (resultSet.next()) {
            Author author = new Author();
            author.setId(resultSet.getInt("id"));
            author.setName(resultSet.getString("name"));
            author.setSurname(resultSet.getString("surname"));
            author.setEmail(resultSet.getString("email"));
            author.setAge(resultSet.getInt("age"));


            return author;
        }
        return null;
    }

    public void removeAuthorById(int id) {
        String sql = "delete from author where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
