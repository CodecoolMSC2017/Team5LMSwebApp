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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/protected/attendanceServlet")
public class AttendanceServlet extends HttpServlet {
    public String currentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] attendances = req.getParameterValues("attendance");
        List<Registration> students = SingletonDataBase.getInstance().getStudents();
        List<Registration> currentStudents = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (attendances[i].equals("1")) {
                currentStudents.add(students.get(i));
            }
        }


        if (SingletonDataBase.getInstance().getAttendancesTitle().contains(currentDate())) {

            req.setAttribute("error", "This day's attendance is already checked.");

        } else {
            Attendance attendance = new Attendance(currentStudents);
            SingletonDataBase.getInstance().getAttendanceList().add(attendance);
            Map<Registration, Integer> studentsAttendance = SingletonDataBase.getInstance().getStudentsAttendance();
            int days = SingletonDataBase.getInstance().getAttendanceList().size();

            for (Registration reg : SingletonDataBase.getInstance().getStudents()) {
                int temp = studentsAttendance.get(reg);
                float att = (float) temp / days * 100;
                reg.setAttendance(att);
            }

        }

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);
        req.setAttribute("date", currentDate());

        req.setAttribute("studentlist", SingletonDataBase.getInstance().getStudents());
        req.getRequestDispatcher("attendance.jsp").include(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        Map<Registration, Integer> studentsAttendance = SingletonDataBase.getInstance().getStudentsAttendance();
        int days = SingletonDataBase.getInstance().getAttendanceList().size();

        for (Registration reg1 : SingletonDataBase.getInstance().getStudents()) {
            try {
                int temp = studentsAttendance.get(reg1);
                float att = (float) temp / days * 100;
                reg1.setAttendance(att);
            } catch (NullPointerException e) {
                reg1.setAttendance(0);
            }
        }
        req.setAttribute("studentlist", SingletonDataBase.getInstance().getStudents());
        req.setAttribute("date", currentDate());
        req.getRequestDispatcher("attendance.jsp").include(req, resp);
    }
}
