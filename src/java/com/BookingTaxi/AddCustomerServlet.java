package com.BookingTaxi;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class AddCustomerServlet extends HttpServlet {
    RequestDispatcher rd;
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        String btn=req.getParameter("signBtn");
        HttpSession session=req.getSession(true);
        AESSecurity aes=new AESSecurity();
        
        if(btn!=null){
            String name=req.getParameter("uname");
            String pass=req.getParameter("upass");
            if(DBClass.Customer_list.containsKey(name)){
                req.setAttribute("loginErr","User Already Exist Log In to Continue");
                rd=req.getRequestDispatcher("index.jsp");
                rd.forward(req, res);
            }
            else{
                Customer customer = new Customer();
                customer.setName(name);
                try {
                    customer.setPass(aes.encrypt(pass));
                } catch (Exception ex) {
                    System.out.println("Exception at AddCustomerServlet while adding new customer "+ex);
                }
                DBClass.Customer_list.put(name, customer);
                session.setAttribute("curr_user", customer);
                System.out.println("In Add Cutomer Password Verified ");
                res.sendRedirect("customerActions.jsp");
            }
        }
    }

   
   
}

    


