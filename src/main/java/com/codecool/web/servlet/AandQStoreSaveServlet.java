package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AandQService;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/protected/AandQStoreSaveServlet")
public class AandQStoreSaveServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        AandQService service = new AandQService();
        AandQStore aandQStore = service.getAandQStore(id);

        String title = req.getParameter("title");
        aandQStore.setTitle(title);

        req.setAttribute("profile", req.getSession().getAttribute("user"));
        req.setAttribute("userProfile", req.getSession().getAttribute("user"));


        req.getRequestDispatcher("AandQStoreServlet").forward(req, resp);
    }
}
