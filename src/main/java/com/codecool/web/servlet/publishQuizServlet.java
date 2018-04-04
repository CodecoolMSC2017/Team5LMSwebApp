package com.codecool.web.servlet;

import com.codecool.web.model.AandQStore;
import com.codecool.web.model.Assignment;
import com.codecool.web.model.Quiz;
import com.codecool.web.model.SingletonDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/protected/publishQuizServlet")
public class publishQuizServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        for (AandQStore store:SingletonDataBase.getInstance().getaQStores()){
            for (Quiz q:store.getQuizzes()){
                if(id == q.getId()){
                    if(q.isPublished()){
                        q.setPublished(false);
                    }else{
                        q.setPublished(true);
                    }
                }
            }
        }
        resp.sendRedirect("AandQStoreServlet");
    }
}
