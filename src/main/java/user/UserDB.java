package user;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDB {

    private Logger connectionLogger = Logger.getLogger(UserDB.class.getName());

    public void addUser(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "123");

        String sql = new StringBuilder()
                .append("insert into users(username, password) values('" + username + "', '" + password + "');")
                .toString();

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        con.close();
    }

    public List<User> getUsers() throws SQLException, ClassNotFoundException {

        List<User> userlist = new ArrayList<User>();
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "123");

        String retrieveDataQuery = new StringBuilder()
                .append("select * from users;")
                .toString();

      //  connectionLogger.log();


        PreparedStatement stmt2 = con.prepareStatement(retrieveDataQuery);
        ResultSet resultSet = stmt2.executeQuery();


        while (resultSet.next()) {
            userlist.add(new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password")));
        }

        return userlist;

    }



}
