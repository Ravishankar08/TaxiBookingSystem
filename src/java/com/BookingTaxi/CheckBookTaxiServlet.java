package com.BookingTaxi;

import java.io.IOException;
import java.text.DateFormat;

import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckBookTaxiServlet extends HttpServlet {

    HttpSession session;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int start_loc = Integer.parseInt(req.getParameter("start_loc"));
        int drop_loc = Integer.parseInt(req.getParameter("drop_loc"));
        String time = req.getParameter("user_time");
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e) {
            req.setAttribute("bookerr", "time must be given as per the format HH:MM AM");
            RequestDispatcher rd = req.getRequestDispatcher("BookTaxies.jsp");
            rd.forward(req, res);
        }

        if (start_loc == drop_loc) {
            req.setAttribute("bookerr", "Sorry both the source and the destination are same");
            RequestDispatcher rd = req.getRequestDispatcher("BookTaxies.jsp");
            rd.forward(req, res);
            System.out.println("Same values");
        } else {
            session = req.getSession();
            Customer customer = (Customer) session.getAttribute("curr_user");
            try{
            Taxi t1 = new Taxi();
            TaxiOrders order = t1.AllotTaxi(start_loc, drop_loc, date, customer.getName());
            if (order != null) {
                customer.setCustomerDetails(date,order.getPickUpTime(), order.getDropTime(), order.getFrom(), order.getTo(), order.getTaxiId(), order.getPrice());
                req.setAttribute("orders", order);
                 req.getRequestDispatcher("OrdersSuccess.jsp").forward(req,res);

            } else {
                res.getWriter().println("Sorry No taxi available at this moment");
            }}
            catch(Exception e){
                System.out.println("Exception at checkNookTaxi  : "+e+" "+e.getStackTrace()[0].getLineNumber());
            }
        }
    }

}
