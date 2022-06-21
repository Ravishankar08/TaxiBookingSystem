
<%@page import="com.BookingTaxi.DBClass"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.BookingTaxi.TaxiOrders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Successful</title>
    </head>
    <body>
        <%SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        TaxiOrders order=(TaxiOrders)request.getAttribute("orders");
        %>
        <h1>Order initiated Successfully</h1>
        <table>
            <tr>
                <td>Taxi Alloted :</td>
                <td>Taxi<%=order.getTaxiId()%></td>
            </tr>
            <tr>
                <td>Source</td>
                <td><%=DBClass.place[order.getFrom()].getPlaceName()%></td>
            </tr>
            <tr>
                <td>Destination</td>
                <td><%=DBClass.place[order.getTo()].getPlaceName()%></td>
            </tr>
            <tr>
                <td>Total Price</td>
                <td><%=order.getPrice()%></td>
            </tr>
            <tr>
                <td>Request Time</td>
                <td><%=formatter.format(order.getReqTime())%></td>
            </tr>
            <tr>
                <td>Pickup Time</td>
                <td><%=formatter.format(order.getPickUpTime())%></td>
            </tr>
            <tr>
                <td>Drop Time</td>
                <td><%=formatter.format(order.getDropTime())%></td>
            </tr>
            
        </table>
            <br>
            <br>
            <form action="logout" method="get">
            <button type="submit" name="logbtn">Logout</button>
            </form>
    </body>
</html>
