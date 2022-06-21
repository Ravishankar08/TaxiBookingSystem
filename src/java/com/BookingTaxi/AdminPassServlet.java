package com.BookingTaxi;

import javax.servlet.http.*;

public class AdminPassServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            if (req.getParameter("passAdmin") != null) {
                Admin admin= new Admin();
                AESSecurity aes = new AESSecurity();
                if (aes.encrypt(req.getParameter("passAdmin")).equals(admin.getPassword())) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("isAdminLogged", true);
                    res.sendRedirect("Admin_Flow.jsp");
                } else {
                    System.out.println("Password doesnot match");
                    req.setAttribute("AdminErr", "Admin Password Invalid");
                    req.getRequestDispatcher("Admin_Pass.jsp").forward(req, res);
                }
            } else {
                System.out.println("No user Found");
                req.setAttribute("AdminErr", "Admin Password Invalid");
                req.getRequestDispatcher("Admin_Pass.jsp").forward(req, res);
            }
        } catch (Exception e) {
            System.out.println("Exception at AdminPassServlet : " + e);
        }

    }
}
