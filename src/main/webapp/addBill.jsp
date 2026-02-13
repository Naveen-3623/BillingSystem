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

    <input type="hidden" name="operation" value="newRecord">

    Customer Name: <input type="text" name="customerName"><br><br>

    Product Name: <input type="text" name="productName"><br><br>

    Bill Date: <input type="date" name="billDate"><br><br>

    Quantity: <input type="number" name="quantity"><br><br>

    Price: <input type="number" step="0.01" name="price"><br><br>

    Remarks: <input type="text" name="remarks"><br><br>

    <input type="submit" value="Add Bill">

</form>
<br>

<a href="menu.html">Go Back</a>
</body>
</html>