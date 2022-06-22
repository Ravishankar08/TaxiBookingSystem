package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
            HttpSession session = req.getSession(false);
            session.invalidate();
            res.sendRedirect("index.jsp");
    }

}
