


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book a taxi</title>
    </head>
    <body>
        <% //request.setAttribute("bookerr"," ");%>

        <h1>Book a Taxi</h1>
        <form action="checkBook" method="post">
            Enter the PickUp Location :
            <select name="start_loc" required>
                <option value="1">DLF</option>
                <option value="2">Velachery</option>
                <option value="3">Tambaram</option>
                <option value="4">T Nagar</option>
                <option value="5">Nungambakkam</option>
            </select><br><br>
            Enter the Drop Location :
            <select name="drop_loc" required>
                <option value="1">DLF</option>
                <option value="2">Velachery</option>
                <option value="3">Tambaram</option>
                <option value="4">T Nagar</option>
                <option value="5">Nungambakkam</option>
            </select><br><br>
            Enter the PickUp Time
            <input type="text" name="user_time" autocomplete="off" required>
            <br><br>
            <div style="color: red">
                <%
                    try {
                        String temperr = request.getAttribute("bookerr").toString();
                        if (temperr != null) {
                            out.println(temperr);
                        }
                    } catch (Exception e) {
                        System.out.println("Exception " + e);
                    }
                %>
                <%request.removeAttribute("bookerr");%>
            </div>
            <input type="submit" name="bookbtn" value="Book">
            <br>
        </form><br>
        <form action="logout" method="get">
            <button type="submit" name="logbtn">Logout</button>
        </form>
    </body>
</html>
