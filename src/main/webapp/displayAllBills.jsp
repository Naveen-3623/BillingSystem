<%@ page import="java.util.List" %>
<%@ page import="com.wipro.billing.bean.BillBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Bills</title>
</head>
<body>

<h2>All Bill Records</h2>

<%
    List<BillBean> list = (List<BillBean>) request.getAttribute("billList");

    if(list == null || list.size() == 0){
%>
        <h3>No records available!</h3>
<%
    } else {
%>
<table border="1">
<tr>
    <th>Bill ID</th>
    <th>Customer</th>
    <th>Product</th>
    <th>Date</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Total</th>
    <th>Remarks</th>
</tr>

<%
    for(BillBean bean : list){
%>

<tr>
    <td><%= bean.getBillId() %></td>
    <td><%= bean.getCustomerName() %></td>
    <td><%= bean.getProductName() %></td>
    <td><%= bean.getBillDate() %></td>
    <td><%= bean.getQuantity() %></td>
    <td><%= bean.getPrice() %></td>
    <td><%= bean.getTotalAmount() %></td>
    <td><%= bean.getRemarks() %></td>
</tr>

<%
    }
%>

</table>

<%
    }
%>
<br>

<a href="menu.html">Go Back</a>

</body>
</html>
