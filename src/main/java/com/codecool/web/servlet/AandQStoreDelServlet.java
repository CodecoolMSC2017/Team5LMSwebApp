package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Registration;
import com.codecool.web.dao.singletonDB.SingletonDataBase;
import com.codecool.web.service.singletonServices.SingletonAandQService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/AandQStoreDelServlet")
public class AandQStoreDelServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Registration reg = (Registration) req.getSession().getAttribute("user");
        req.setAttribute("userProfile", reg);

        SingletonAandQService service = new SingletonAandQService();
        AandQStore delStore = service.getAandQStore(Integer.parseInt(req.getParameter("id")));

        SingletonDataBase.getInstance().getaQStores().remove(delStore);

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
