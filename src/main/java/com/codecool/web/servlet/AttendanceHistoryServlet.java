package com.codecool.web.servlet;


import com.codecool.web.dao.Storing;
import com.codecool.web.dao.database.DaoDB;
import com.codecool.web.model.Attendance;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/protected/AttendanceHistoryServlet")
public class AttendanceHistoryServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);

            req.setAttribute("attendanceHistory", db.getAttendanceList());
            req.getRequestDispatcher("attendanceHistory.jsp").include(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Storing db = new DaoDB(connection);

            List<Registration> students = new ArrayList<>();
            String titleName = req.getParameter("title");
            for (Attendance a:db.getAttendanceList()){
                if(a.getTitle().equals(titleName)){
                    students = a.getCurrentStudents();
                }
            }

            req.setAttribute("students", students);
            req.setAttribute("title", titleName);

            Registration reg = (Registration) req.getSession().getAttribute("user");
            req.setAttribute("userProfile", reg);

            req.setAttribute("attendanceHistory", db.getAttendanceList());
            req.getRequestDispatcher("attendanceHistory.jsp").include(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
