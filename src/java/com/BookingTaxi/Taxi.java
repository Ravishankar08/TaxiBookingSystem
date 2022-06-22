package com.BookingTaxi;

import java.util.*;

public class Taxi {

    ArrayList<TaxiTimes> taxitimes;
    static int id_inc = 0;
    static List<Taxi> FreeTaxi = new ArrayList<>();
    public ArrayList<TaxiOrders> OrdersOfTaxi = new ArrayList<>();
    public int id, salary;
    public int travelMin;

    public void setRest(boolean rest) {
        this.rest = rest;
    }

    public static void sort(ArrayList<TaxiTimes> list) {
        list.sort((o1, o2)
                -> o1.startTime.compareTo(
                        o2.startTime));
    }

    public Taxi() {
        this.taxitimes = new ArrayList<>();
        this.id = id_inc;
        this.salary = 0;
        this.rest = false;
        id_inc++;
    }

    public static int getId_inc() {
        return id_inc;
    }

    private boolean rest;

    public int getId() {
        return id;
    }

    public int getCurr_pos(Date time) {
        System.out.println("The time reqyested is " + time);
        if (taxitimes.isEmpty()) {
            return 1;
        }
        sort(taxitimes);
        System.out.println(taxitimes);
        TaxiOrders order = null;
        for (TaxiTimes taxitime : this.taxitimes) {
            if (time.before(taxitime.startTime)) {
                break;
            } else if (time.equals(taxitime.startTime)) {
                if (order == null) {
                    return 1;
                }
                break;
            } else {
                order = taxitime.order;
            }
        }
        if (order == null) {
            System.out.println("ALL orders are above " + time);
            return 1;
        }
        System.out.println("If Near Order" + order.getTo());
        return order.getTo();
    }

    public int getSalary() {
        return salary;
    }

    public boolean isRest() {
        return rest;
    }

    public TaxiOrders AllotTaxi(int start_loc, int stop_loc, Date Time, String Username) {
        TaxiOrders order = new TaxiOrders();
        int minSalary = Integer.MAX_VALUE;
        FreeTaxi.clear();

        int pickUpMin , largestTravelMin = Integer.MAX_VALUE, smallestTravelMin = largestTravelMin;
        for (Taxi taxi : DBClass.Taxi_List) {
            pickUpMin = Math.abs(start_loc - taxi.getCurr_pos(Time)) * 15;
            System.out.println("startTime " + start_loc + "curr pos" + taxi.getCurr_pos(Time) + "pickUpmin " + pickUpMin);
            taxi.travelMin = pickUpMin + Math.abs(start_loc - stop_loc) * 15;
            System.out.println("travelMin " + taxi.travelMin);

        }

        Taxi AllotedTaxi = null;
        for (Taxi taxi : DBClass.Taxi_List) {
            if (taxi.check(Time, taxi.travelMin)) {
                FreeTaxi.add(taxi);
            }
        }
        Collections.sort(FreeTaxi, new MyComparator(
                new TravelTimeComparator(),
                new salaryComparator()
        ));
        
        
        

        if (FreeTaxi.isEmpty() ) {
            System.out.println("Sorry No Taxi is Alloted");
            return null;
        }
        AllotedTaxi=FreeTaxi.get(0);
        System.out.println("Calling the check time" + Time + " Allotes Taxi" + AllotedTaxi.getId());

        int price = Math.abs(start_loc - stop_loc) * 150;
        int orderloss = Math.abs(AllotedTaxi.getCurr_pos(Time) - start_loc) * 75;
        AllotedTaxi.salary += price - orderloss;
        Date dropTime = new Date(Time.getTime() + (AllotedTaxi.travelMin * 60 * 1000));
        pickUpMin = Math.abs(start_loc - AllotedTaxi.getCurr_pos(Time)) * 15;
        order.setValues(AllotedTaxi.getId(), start_loc, stop_loc, price, Time, new Date(Time.getTime() + (pickUpMin * 60 * 1000)), dropTime, Username, orderloss);
        AllotedTaxi.OrdersOfTaxi.add(order);
        TaxiTimes taxitime = new TaxiTimes();
        taxitime.startTime = Time;
        taxitime.endTime = dropTime;
        taxitime.order = order;
        System.out.println("Orders added to taxitimes");
        AllotedTaxi.taxitimes.add(taxitime);

        return order;

    }

    private boolean check(Date ReqTime, int travelMin) {
        int check = 0;
        Date dropTime = new Date(ReqTime.getTime() + (travelMin) * 60 * 1000);
        System.out.println("startTime : " + ReqTime + "tarvel Min : " + travelMin + " DropTime ; " + dropTime);
        System.out.println(taxitimes);
        if (this.taxitimes.isEmpty()) {
            System.out.println("taxitmes empty");
            return true;
        }
        if (this.rest) {
            System.out.println("taxi i s ata rest");
            return false;
        }

        for (TaxiTimes taxitime : this.taxitimes) {
            check = 0;
            System.out.println("here in check");
            System.out.println("taxi Requested Time" + ReqTime.toString() + "taxi endTime:" + taxitime.endTime.toString() + " Start time: " + taxitime.startTime.toString());
            if (!(ReqTime.after(taxitime.endTime) || dropTime.before(taxitime.startTime))) {
                System.out.println("inside");
                check = 1;
            } else {
                System.out.println("Outside");
            }

        }
        return check == 0;
    }

}
//    void busyCheck(Date time) {
//        for (Taxi taxi : DBClass.Taxi_List) {
//            if (taxi.busyTime.isEmpty()) {
//                System.out.println("Empty taxi busy time");
//                taxi.busy = false;
//            } else {
//                int check = 0;
//                System.out.println("Else block");
////                for(Date d[]:taxi.busyTime){
////                    if(!time.before(d[0]) || !time.after(d[1])){
////                        check=1;
////                        break;
////                    }
////                    taxi.busy=(check != 0);
////                    System.out.println("Taxi "+taxi.getId()+"Check "+taxi.busy);
////                }
//
//                for (Date init : taxi.busyTime.keySet()) {
//                    if (time.after(taxi.busyTime.get(init)) || time.before(init)) {
//                    } else {
//                        System.out.println("time : "+time+" pick "+init+" after : "+taxi.busyTime.get(init));
//                        check = 1;
//                        break;
//                    }
//
//                }
//                taxi.busy = (check != 0);
//                System.out.println("Taxi " + taxi.getId() + "Check " + taxi.busy);
//
//            }
//        }
////        for (Taxi taxi : DBClass.Taxi_List) {
////            if (taxi.freeTime.before(time)) {
////                System.out.println("free : " + taxi.freeTime + " ANd " + time);
////                taxi.busy = false;
////            } else {
////                System.out.println("not : " + taxi.freeTime + " ANd " + time);
////                taxi.busy = true;
////            }
////        }
//    }
//
//    void checkFreeTaxi(Date Time) {
//        FreeTaxi.clear();
//        try {
//            busyCheck(Time);
//        } catch (Exception e) {
//            System.out.println("err" + e);
//        }
//        for (Taxi t : DBClass.Taxi_List) {
//            if (t.busy == false && t.rest == false) {
//                FreeTaxi.add(t);
//            }
//        }
//        System.out.println("freetaxi : " + FreeTaxi);
//
//    }
//
//    public TaxiOrders AllotTaxi(int start_loc, int stop_loc, Date Time, String Username) {
//        checkFreeTaxi(Time);
//        int min_d = 75;
//        ArrayList<Taxi> nearestTaxi = new ArrayList<>();
//        for (Taxi taxi : FreeTaxi) {
//            taxi.user_dist = (taxi.curr_pos > start_loc) ? (taxi.curr_pos - start_loc) * 15 : (start_loc - taxi.curr_pos) * 15;
//            System.out.println("taxi : " + taxi.user_dist + " curr: " + taxi.curr_pos + " start : " + start_loc);
//            if (taxi.user_dist < min_d) {
//                min_d = taxi.user_dist;
//            }
//        }
//
//        for (Taxi taxi : FreeTaxi) {
//            if (taxi.user_dist == min_d) {
//                nearestTaxi.add(taxi);
//            }
//        }
//        if (nearestTaxi.isEmpty()) {
//            System.out.println("No Taxi Alloted");
//            return null;
//        }
//        System.out.println("nerarestTaxi : " + nearestTaxi);
//        Taxi allotedTaxi = new Taxi();
//        int min_salary = Integer.MAX_VALUE;
//        for (Taxi taxi : nearestTaxi) {
//            if (min_salary > taxi.salary) {
//                min_salary = taxi.salary;
//                allotedTaxi = taxi;
//            }
//        }
//        System.out.println("AllotedTaxi " + allotedTaxi.id);
//        return cnfrmTaxi(allotedTaxi, start_loc, stop_loc, Time, Username);
//
//    }
//
//    private TaxiOrders cnfrmTaxi(Taxi taxi, int start_loc, int stop_loc, Date Time, String CustomerName) {
//        Date pickUp,freeTime;
//        int curr_cost;
//        TaxiOrders order = new TaxiOrders();
//        taxi.busy = true;
//        
//        taxi.salary += Math.abs(start_loc - stop_loc) * 150;
//        System.out.println("salary : " + taxi.salary + " start : " + start_loc + " stop : " + stop_loc);
//        int taxiLoss = Math.abs(taxi.curr_pos - start_loc) * 75;
//        taxi.salary -= taxiLoss;
//        System.out.println("Loss: " + taxiLoss);
//        int pickTimemin = taxi.user_dist;
//        freeTime = Time;
//        taxi.curr_pos = stop_loc;
//        System.out.println("time : " + pickTimemin);
//        pickUp = new Date(freeTime.getTime() + (pickTimemin * 60 * 1000));
//        System.out.println("Pick Up at : " + pickUp);
//        int tot_time = Math.abs(start_loc - stop_loc) * 15;
//        freeTime = new Date(pickUp.getTime() + (tot_time * 60 * 1000));
//        System.out.println(freeTime + "salary : " + taxi.salary);
//        curr_cost = Math.abs(start_loc - stop_loc) * 150;
//
//        taxi.busyTime.put(Time, freeTime);
//
//        order.setValues(taxi.id, start_loc, stop_loc, curr_cost, pickUp, freeTime, CustomerName,taxiLoss);
//        taxi.OrdersOfTaxi.add(order);
//        return order;
//
//    }

