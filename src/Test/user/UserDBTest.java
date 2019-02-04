package user;

import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDBTest extends UserDB {

    private UserDB testdb = new UserDB();

    @Test
    public void addUser() throws SQLException, ClassNotFoundException {

    List<User> users = testdb.getUsers();

    users.forEach(System.out::println);

    }

    @Test
    public void addUserTest() throws SQLException, ClassNotFoundException {

        testdb.addUser("test1","parola1");

    }
}