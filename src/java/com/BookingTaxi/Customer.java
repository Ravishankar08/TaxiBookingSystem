package com.BookingTaxi;


import java.util.ArrayList;
import java.util.Date;


public class Customer {
    private String name,pass;
    public ArrayList<TaxiOrders> CustomerOrders= new ArrayList<>();

   public void setCustomerDetails(Date reqTime,Date start,Date drop,int from,int to,int TaxiId,int cost){
       TaxiOrders order= new TaxiOrders();
       order.setValues(TaxiId, from, to, cost,reqTime ,start, drop,this.name,0);
       CustomerOrders.add(order);
       System.out.println("Orders added");
   }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
