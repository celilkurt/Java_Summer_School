<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<form action="j_security_check" method=post>
        <p><strong>Please Enter Your User Name: </strong>
        <input type="text" name="j_username" size="25">
        <p><p><strong>Please Enter Your Password: </strong>
        <input type="password" size="15" name="j_password">
        <p><p>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>