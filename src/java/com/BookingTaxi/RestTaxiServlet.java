package com.BookingTaxi;

import java.io.IOException;
import javax.servlet.http.*;

public class RestTaxiServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String btn = req.getParameter("btn");
        System.out.println(btn);
        if (btn.equals("restbtn")) {
            int Taxino = Integer.parseInt(req.getParameter("taxino"));
            DBClass.Taxi_List[Taxino].setRest(true);
//            res.getWriter().print("Taxi " + Taxino + " has become to rest");
            res.sendRedirect("Admin_Flow.jsp");
            System.out.println("Rest" + Taxino);

        } else if (btn.equals("unrestbtn")) {
            int Taxino = Integer.parseInt(req.getParameter("taxino2"));
            DBClass.Taxi_List[Taxino].setRest(false);
//            res.getWriter().print("Taxi " + Taxino + " has become unrest");
            res.sendRedirect("Admin_Flow.jsp");
            System.out.println("UNRest" + Taxino);
        }
    }
}
