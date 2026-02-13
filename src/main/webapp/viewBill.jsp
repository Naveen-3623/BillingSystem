<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="viewRecord">

    Customer Name: <input type="text" name="customerName"><br><br>

    Bill Date: <input type="date" name="billDate"><br><br>

    <input type="submit" value="Search">

</form>
<br>

<a href="menu.html">Go Back</a>

</body>
</html>