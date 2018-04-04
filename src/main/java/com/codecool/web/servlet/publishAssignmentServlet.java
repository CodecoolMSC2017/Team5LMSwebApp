package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Registration;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/protected/publishAssignmentServlet")
public class publishAssignmentServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        for (AandQStore store:SingletonDataBase.getInstance().getaQStores()){
            for (Assignment a:store.getAssignments()){
                if(id == a.getId()){
                    if(a.isPublished()){
                        a.setPublished(false);
                    }else{
                        a.setPublished(true);
                    }
                }
            }
        }

        resp.sendRedirect("AandQStoreServlet");
    }
}
