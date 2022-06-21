
package com.BookingTaxi;

import java.util.Date;

public class TaxiOrders {
    private int TaxiId;
    private int from,to;
    private int price,loss;
    private String customerName;
    

    public String getCustomerName() {
        return customerName;
    }
    private  Date PickUpTime,DropTime,ReqTime;

    public int getTaxiId() {
        return TaxiId;
    }

    public Date getReqTime() {
        return ReqTime;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public Date getPickUpTime() {
        return PickUpTime;
    }

    public Date getDropTime() {
        return DropTime;
    }
    public void setValues(int taxiId,int from,int to,int price,Date ReqTime,Date pickTime,Date dropTime,String u_name,int loss){
        this.TaxiId=taxiId;
        this.from=from;
        this.to=to;
        this.price=price;
        this.PickUpTime=pickTime;
        this.DropTime=dropTime;
        this.customerName=u_name;
        this.loss=loss;
        this.ReqTime=ReqTime;
    }
    

    public int getLoss() {
        return loss;
    }
    
   
    
}
