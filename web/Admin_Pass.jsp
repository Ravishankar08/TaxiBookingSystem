

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter the Admin Password</title>
    </head>
    <body>
        <h1>Enter the Admin Password:</h1>
        <form method="post" action="AdminPassServlet">
            <input type="password" name="passAdmin" required ><br>
            <button type="submit" >Submit</button>
        </form>
        <div style="color: red">
        <%
            if (request.getAttribute("AdminErr") != null) {
                out.print(request.getAttribute("AdminErr"));
            }
        %>
        </div>
    </body>
</html>
