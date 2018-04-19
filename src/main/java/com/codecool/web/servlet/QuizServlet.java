package com.codecool.web.servlet;

import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.*;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.QuizService;
import com.codecool.web.service.databaseServices.DatabaseAssignmentService;
import com.codecool.web.service.databaseServices.DatabaseQuizService;
import com.codecool.web.service.singletonServices.SingletonQuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/Quiz")
public class QuizServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            int id = Integer.parseInt(req.getParameter("id"));
            QuizService service = new DatabaseQuizService(db);
            req.setAttribute("quiz", service.getQuiz(id));
            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);
            if(reg.getQuizResult().containsKey(id)) {
                Integer points = reg.getQuizResult().get(id);
                req.setAttribute("points", points);
            }

            //Integer points = reg.getPoints();
            final PrintWriter writerA = resp.getWriter();

            req.getRequestDispatcher("quiz.jsp").include(req, resp);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }
}
