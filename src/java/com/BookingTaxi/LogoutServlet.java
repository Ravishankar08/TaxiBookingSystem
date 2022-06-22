package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            HttpSession session = req.getSession(false);
            session.invalidate();
            res.sendRedirect("index.jsp");
        } catch (Exception e) {
            res.sendRedirect("index.jsp");
        }
    }

}
