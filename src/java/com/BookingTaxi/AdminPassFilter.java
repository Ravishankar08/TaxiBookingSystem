package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminPassFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)throws  ServletException, IOException {
        System.out.println("In Admin Filters");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        try{
            HttpSession session=req.getSession(false);
            if((boolean)session.getAttribute("isAdminLogged")){
                chain.doFilter(request, response);
            }
            else{
                req.setAttribute("AdminErr", "Log in to continue");
                req.getRequestDispatcher("Admin_Pass.jsp").forward(req, res);
            }
        }catch(NullPointerException e){
//            System.out.println("Exception at adminFilter"+e+" "+e.getStackTrace()[0].getLineNumber());
            req.setAttribute("AdminErr", "Log in to continue");
            req.getRequestDispatcher("Admin_Pass.jsp").forward(req, res);
        }
    }
}
