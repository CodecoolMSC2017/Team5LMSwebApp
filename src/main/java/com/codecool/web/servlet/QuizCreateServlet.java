package com.codecool.web.servlet;

import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.model.*;
import com.codecool.web.service.singletonServices.SingletonAandQService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/QuizCreateServlet")
public class QuizCreateServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        int aQID = Integer.parseInt(req.getParameter("id"));
        SingletonAandQService service = new SingletonAandQService();
        AandQStore aandQStore = service.getAandQStore(aQID);
        Quiz quiz = new Quiz("New Quiz", "New Quiz Description");
        aandQStore.getQuizzes().add(quiz);

        if (reg.getRole().equals("Mentor")) {
            req.setAttribute("AandQlist", SingletonDataBase.getInstance().getaQStores());
        }else{
            req.setAttribute("AandQlist", SingletonDataBase.getInstance().getAQStoresPublished());
        }

        req.getRequestDispatcher("assignments.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        doGet(req, resp);
    }

}
