

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.BookingTaxi.*"%>
<html>
    <head>
        <title>User Details</title>
    </head>
    <body>
        <%

            try {
                Customer customer = (Customer) session.getAttribute("curr_user");

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
                int i = 1;
        %>
        <h1><%="Welcome " + customer.getName()%></h1>
        <%

            for (TaxiOrders order : customer.CustomerOrders) {


        %>
        <ul>
            <li>

                <%="Order " + i + " : "%>

                <ul>
                    <li><%="The Taxi Alloted is : Taxi" + order.getTaxiId()%></li>
                    <li><%="Cost : " + order.getPrice()%></li>
                    <li><%="From : " + DBClass.place[order.getFrom()].getPlaceName()%></li>
                    <li><%="Destination : " + DBClass.place[order.getTo()].getPlaceName()%></li>
                    <li><%="Request Time: " + formatter.format(order.getPickUpTime())%></li>
                    <li><%="Pick Up Time : " + formatter.format(order.getPickUpTime())%></li>
                    <li><%="Drop Time : " + formatter.format(order.getDropTime())%></li>

                </ul>
                <%i += 1;%>
            </li>
        </ul>
        <%
                }
            } catch (Exception e) {
//                response.sendRedirect("index.jsp");
            }
        %>
        <br>
        <form action="logout" method="get">
            <button type="submit" name="logbtn">Logout</button>
        </form>

    </body>
</html>
