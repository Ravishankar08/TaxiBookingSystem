
<%@page import="com.BookingTaxi.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actions</title>
    </head>
    <body>
        <h1>The Customer  Actions  :</h1>
        <ul>
            <li><a href="BookTaxies.jsp">Book a Taxi</a></li>
            <li><a href="UserDetails.jsp">Show Details</a></li>
        </ul>
        <br>
        <br>
        <form action="logout" method="get">
            <button type="submit" name="logbtn">Logout</button>
        </form>
        <%--<%= //Admin.Customer_list%>--%>
    </body>
</html>
