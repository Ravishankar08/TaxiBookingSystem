package com.BookingTaxi;

import java.util.*;

public class MyComparator implements Comparator<Taxi> {

    private List<Comparator<Taxi>> listTaxi;

    public MyComparator(Comparator<Taxi>... taxi) {
        this.listTaxi = Arrays.asList(taxi);
    }

    public int compare(Taxi t1, Taxi t2) {
        for (Comparator<Taxi> comparator : listTaxi) {
            int result = comparator.compare(t1, t2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

class TravelTimeComparator implements Comparator<Taxi> {

    @Override
    public int compare(Taxi o1, Taxi o2) {
        return o1.travelMin - o2.travelMin;
    }

}

class salaryComparator implements Comparator<Taxi> {

    @Override
    public int compare(Taxi o1, Taxi o2) {
        return o1.getSalary() - o2.getSalary();
    }

}

class sortItems implements Comparator<TaxiTimes> {

    public int compare(TaxiTimes a, TaxiTimes b) {

        return a.startTime.compareTo(b.startTime);
    }
}
