package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserLogFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("In Customer login Filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if (session.getAttribute("curr_user") != null) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("loginErr", "Log in to continue");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }

    }
}
