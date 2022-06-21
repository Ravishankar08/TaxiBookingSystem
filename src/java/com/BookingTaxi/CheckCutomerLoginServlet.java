package com.BookingTaxi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CheckCutomerLoginServlet extends HttpServlet {

    RequestDispatcher rd;
    HttpSession session;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        AESSecurity aes = new AESSecurity();
        if (req.getParameter("logBtn") != null) {
            String name = req.getParameter("uname");
            String pass = req.getParameter("upass");
            if (DBClass.Customer_list.containsKey(name)) {
                try {
                    if (!DBClass.Customer_list.get(name).getPass().equals(aes.encrypt(pass))) {
                        req.setAttribute("loginErr", "User Name Password Mismatch");
                        req.getRequestDispatcher("index.jsp").forward(req, res);
                    } else {
                        session = req.getSession(true);
                        session.setAttribute("curr_user", DBClass.Customer_list.get(name));
                        res.sendRedirect("customerActions.jsp");
                    }
                } catch (Exception ex) {
                    System.out.println("Exception at check Customer Login " + ex);
                }
            } 
            else {
                req.setAttribute("loginErr", "No User Found");
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        }
    }

}
