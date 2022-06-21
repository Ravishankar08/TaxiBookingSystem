

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.BookingTaxi.*"  %>
<html>
    <head>
        <title>Login Page</title>

    </head>
    <body>
        <div style="text-align: right"><a href="Admin_Pass.jsp">Admin</a></div>
        <h1>Login Page</h1>
        <br>
        <div style="color: red">
            <%

                    if (request.getAttribute("loginErr") != null) {
                        out.println(request.getAttribute("loginErr"));
                    }
            %>
        </div>
        <form action="checkLog" method="post">
            Enter the Name:
            <input type="text" name="uname" autocomplete="off"><br>
            Enter the Password : 
            <input type="password" name="upass" autocomplete="off"><br>
            <button type="submit" name="logBtn">Login</button>
        </form>

        <a href="signUp.jsp">New User?</a>

    </body>
</html>
