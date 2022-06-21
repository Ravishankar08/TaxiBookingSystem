
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.BookingTaxi.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Customer List</title>
    </head>
    <body>
        <h1>Details of the customer </h1>
        <ul>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
                for (String c : DBClass.Customer_list.keySet()) {
                    int i = 1;
            %>

            <li><%="User Name : " + c%></li>

            <%

                for (TaxiOrders t : DBClass.Customer_list.get(c).CustomerOrders) {

            %>
            <ul>
                <li>

                    <%="Order " + i + " : "%>

                    <ul>
                        <li><%="The Taxi Alloted is : Taxi" + t.getTaxiId()%></li>
                        <li><%="Cost : " + t.getPrice()%></li>
                        <li><%="From : " + DBClass.place[t.getFrom()].getPlaceName()%></li>
                        <li><%="Destination : " + DBClass.place[t.getTo()].getPlaceName()%></li>
                        <li><%="Request Time: " + formatter.format(t.getPickUpTime())%></li>
                        <li><%="Pick Up Time : " + formatter.format(t.getPickUpTime())%></li>
                        <li><%="Drop Time : " + formatter.format(t.getDropTime())%></li>

                    </ul>
                    <%i += 1;%>
                </li>
            </ul>
            <%
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