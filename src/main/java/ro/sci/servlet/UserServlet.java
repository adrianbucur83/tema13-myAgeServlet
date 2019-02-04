package ro.sci.servlet;

import user.User;
import user.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet{



        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.getWriter().println("Retrieving all users from db: \n");
            UserDB userDB = new UserDB();

            try {
                List<User> returnedUsers = userDB.getUsers();

                for (User returnedUser : returnedUsers) {
                    resp.getWriter().println("User id: " + returnedUser.getId() + "| username: " + returnedUser.getName() + "| password: " + returnedUser.getPassword());
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            resp.getWriter().println("End of usernames");
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            UserDB getBusy = new UserDB();
            String username = req.getParameter("username");
            String password = req.getParameter("password");


            try {
                getBusy.addUser(username, password);


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            resp.getWriter().println("We inserted a username! --->   " + username);
        }


    }



