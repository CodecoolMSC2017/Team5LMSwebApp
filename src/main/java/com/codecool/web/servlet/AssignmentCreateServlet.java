package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.singletonServices.SingletonAandQService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/AssignmentCreateServlet")
public class AssignmentCreateServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        int aQID = Integer.parseInt(req.getParameter("id"));
        SingletonAandQService service = new SingletonAandQService();
        AandQStore aandQStore = service.getAandQStore(aQID);
        Assignment ass = new Assignment("New Assignment", "New Assignment description", 0, "New Assignment long description");
        aandQStore.getAssignments().add(ass);

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
