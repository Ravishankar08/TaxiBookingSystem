

<%@page import="com.BookingTaxi.DBClass"%>
<%@page import="com.BookingTaxi.Taxi"%>
<%@page import="com.BookingTaxi.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Process</title>
    </head>
    <body>
        <h1>Admin process</h1>
        <ul>
            <li><a href="ShowUser.jsp">Check User Details</a></li>
            <li><a href="ShowTaxi.jsp">Check Taxi Details</a></li>
            <br>
            <li>Enter the Taxi to make rest:  
                <form action="RestTaxiServlet" method="get">
                    <input type="number" name="taxino" min="0" max="4" autocomplete="off" required>
                    <button type="submit" name="btn" value="restbtn">Rest</button>
                </form>
            </li>
            
                <h3>Taxis at rest</h3>
                <%
                    for (Taxi taxi : DBClass.Taxi_List) {
                        if (taxi.isRest()) {%>
            <li><%="Taxi " + taxi.getId()%></li>
                <%
                        }
                    }
                %>
            <form action="RestTaxiServlet" method="get">
                <input type="number" name="taxino2" min="0" max="4" autocomplete="off" required>
                <button type="submit" name="btn" value="unrestbtn">Un Rest</button>
            </form>

           
        

        </ul>
        <br>
        <form action="Adminlogout" method="post">
            <button type="submit" name="logbtn">Logout</button>
        </form>

    </body>
</html>
