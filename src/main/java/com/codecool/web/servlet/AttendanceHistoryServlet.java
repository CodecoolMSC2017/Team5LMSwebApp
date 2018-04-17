package com.codecool.web.servlet;


import com.codecool.web.model.Attendance;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/protected/AttendanceHistoryServlet")
public class AttendanceHistoryServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.setAttribute("attendanceHistory", SingletonDataBase.getInstance().getAttendanceList());
        req.getRequestDispatcher("attendanceHistory.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Registration> students = new ArrayList<>();
        String titleName = req.getParameter("title");
        for (Attendance a:SingletonDataBase.getInstance().getAttendanceList()){
            if(a.getTitle().equals(titleName)){
                students = a.getCurrentStudents();
            }
        }

        req.setAttribute("students", students);
        req.setAttribute("title", titleName);

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.setAttribute("attendanceHistory", SingletonDataBase.getInstance().getAttendanceList());
        req.getRequestDispatcher("attendanceHistory.jsp").include(req, resp);
    }
}
