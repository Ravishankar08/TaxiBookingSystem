
<%@page import="com.BookingTaxi.DBClass"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.BookingTaxi.TaxiOrders"%>
<%@page import="com.BookingTaxi.Admin"%>
<%@page import="com.BookingTaxi.Taxi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Taxi list</title>
    </head>
    <body>
        <h1>Taxi List</h1>
        <ul>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
                for (Taxi taxi : DBClass.Taxi_List) {
                    int count = 1;
            %>
            <li><%="Taxi " + taxi.getId() + " &nbsp &nbsp Salary : " + taxi.getSalary()%></li>

            <%
                for (TaxiOrders order : taxi.OrdersOfTaxi) {

            %>
            <ul>

                <li>
                    <%="Order " + count%>
                    <ul>
                        <li><%="Customer :" + order.getCustomerName()%></li>
                        <li><%="Cost  : " + order.getPrice()%></li>
                        <li><%="From : " + DBClass.place[order.getFrom()].getPlaceName()%></li>
                        <li><%= "Destination : " + DBClass.place[order.getTo()].getPlaceName()%></li>
                        <li><%="Request Time: " + formatter.format(order.getReqTime())%></li>
                        <li><%="Pick Up Time : " + formatter.format(order.getPickUpTime())%></li>
                        <li><%="Drop Time : " + formatter.format(order.getDropTime())%></li>
                        <li><%="Taxi Loss : " + order.getLoss()%></li>

                    </ul>
                    <%count++;%>

                </li>
            </ul><%
                    }
                }
            %>
        </ul>
        <br>
        <form action="Adminlogout" method="post">
            <button type="submit" name="logbtn">Logout</button>
        </form>
    </body>
</html>
