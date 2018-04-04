package com.codecool.web.servlet;

import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("protected/attendanceServlet")
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] attendances = req.getParameterValues("attendance");
        List<Registration> students = SingletonDataBase.getInstance().getStudents();

        for (int i = 0; i <students.size() ; i++) {
            students.get(i).setAttendance(Integer.parseInt(attendances[i]));
        }

        SingletonDataBase.getInstance().setGlobalAttandance(1);

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.setAttribute("studentlist", SingletonDataBase.getInstance().getStudents());
        req.getRequestDispatcher("attendance.jsp").include(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        req.setAttribute("studentlist", SingletonDataBase.getInstance().getStudents());
        req.getRequestDispatcher("attendance.jsp").include(req, resp);
    }
}
