package com.deloitte.ecommerce.ui;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.service.Service;
import com.deloitte.ecommerce.service.ServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/first")
public class LoginCheckServlet extends HttpServlet {

    private Service service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String mobileno = req.getParameter("mobileno");
        String password = req.getParameter("password");
        boolean correct=service.credentialsCorrect(mobileno,password);
        if (correct) {
            HttpSession session=req.getSession();
            session.setAttribute("mobileno",mobileno);
            resp.sendRedirect("/second");
        }else {
            resp.sendRedirect("NewFile1.html");
        }
    }


}







