package com.BookingTaxi;

import java.util.HashMap;

public class DBClass {

    public static HashMap<String, Customer> Customer_list = new HashMap<String, Customer>();
    public static Taxi[] Taxi_List = new Taxi[5];
    public static Places[] place = new Places[6];
    static {
        Taxi_List[0] = new Taxi();
        Taxi_List[1] = new Taxi();
        Taxi_List[2] = new Taxi();
        Taxi_List[3] = new Taxi();
        Taxi_List[4] = new Taxi();
        place[1]=new Places(1,"DLF");
        place[2]=new Places(1,"Velachery");
        place[3]=new Places(1,"Tambaram");
        place[4]=new Places(1,"T Nagar");
        place[5]=new Places(1,"Nugambakam");
        
    }
    

}
