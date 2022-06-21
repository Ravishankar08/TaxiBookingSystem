
package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "AdminLogoutServlet", urlPatterns = {"/Adminlogout"})
public class AdminLogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            HttpSession session = req.getSession(false);
            if ((boolean) session.getAttribute("isAdminLogged")) {
//                session.removeAttribute("isAdminLogged");
                session.invalidate();
                res.sendRedirect("Admin_Pass.jsp");
            }
        } catch (Exception e) {
            System.out.println("Exception at adminLogoutServlet"+e);
        }
    }

}
