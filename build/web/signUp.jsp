
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up Page</title>
        
    </head>
    <body>
        <h1>Sign Up Page</h1>
        <br>
        <form action="addcustomer" method="post">
            Enter the Name:
            <input type="text" name="uname" autocomplete="off" required ><br>
            Enter the Password : 
            <input type="password" name="upass" autocomplete="off" required><br>
            <button type="submit" name="signBtn">Sign Up</button>
        </form><br>
        <a href="index.jsp">Already have an Account?</a>
    </body>
</html>
