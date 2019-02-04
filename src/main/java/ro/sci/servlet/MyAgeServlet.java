package ro.sci.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyAgeServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
            long daysPassed = ChronoUnit.DAYS.between(birthdate, LocalDate.now());
            resp.getWriter().println("It's been " + daysPassed + " days from your birthdate");
        }
        catch (DateTimeException e){
            resp.getWriter().println("Invalid date entered");
        }

    }

}
