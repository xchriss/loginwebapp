<%-- 
    Document   : Login
    Created on : 2018.02.02., 11:42:56
    Author     : Sütikutya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action=""method="POST">
            <table align="center">
                <tr>
                    <th align="right">UserName:</th>
                    <td><input type="text" name="txtusername"></td>
                </tr>
                <tr>
                    <th align="right">Password:</th>
                    <td><input type="password" name="txtpassword"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="Login">
                    </td>
                </tr>
    </body>
</html>
