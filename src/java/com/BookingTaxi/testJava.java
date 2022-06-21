//
//package com.BookingTaxi;
//
//import java.util.*;
//
//
//public class testJava {
//
//   
//    public static void main(String[] args) {
//        Taxi taxi = new Taxi();
//        ArrayList<Taxi>FreeTaxi= new ArrayList<>();
//        taxi.salary=1000;
//        taxi.travelMin=0;
//        FreeTaxi.add(taxi);
//         Taxi taxi1 = new Taxi();
//        taxi1.salary=900;
//        taxi1.travelMin=0;
//        FreeTaxi.add(taxi1);
//         Taxi taxi2 = new Taxi();
//       taxi2.salary=2000;
//       taxi2.travelMin=1;
//       FreeTaxi.add(taxi2);
//        for(Taxi txi:FreeTaxi){
//            System.out.println(txi.travelMin+" "+txi.salary);
//        }
//       Collections.sort(FreeTaxi,new MyComparator(
//               new TravelTimeComparator(),
//               new salaryComparator()
//       ));
//        System.out.println("After");
//       for(Taxi txi:FreeTaxi){
//            System.out.println(txi.travelMin+" "+txi.salary);
//        }
//    }
//    
//}
