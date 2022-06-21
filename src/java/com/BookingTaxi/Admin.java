package com.BookingTaxi;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.*;

public class Admin {

    AESSecurity aes = new AESSecurity();
    private static String passwordAll;    //4H2vgu5RtGST2Ler6GWj9w==
    public  String getPassword(){
        try{
            passwordAll=aes.encrypt("admin");
            System.out.println("here "+passwordAll);
        }catch(Exception e){
            System.out.println("Exception at Admin "+e);
        }
        return passwordAll;
    }
    
 

}
