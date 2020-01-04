package com.deloitte.ecommerce.ui;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.entities.AppUser;
import com.deloitte.ecommerce.service.Service;
import com.deloitte.ecommerce.service.ServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

    private Service service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object mobilenoObj=null;
        if (!sessionDestroyed) {
            mobilenoObj = session.getAttribute("mobileno");
        }

        if (mobilenoObj == null || mobilenoObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='NewFile1.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mobileno=mobilenoObj.toString();
        AppUser user=service.getUserByMobileno(mobileno);
        double balance=user.getBalance();
        String name=user.getName();
        writer.println("Welcome " +name +"Mobileno = "+ mobileno +" Balance="+balance);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}







