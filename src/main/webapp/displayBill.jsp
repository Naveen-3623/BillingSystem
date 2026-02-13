<%@ page import="com.wipro.billing.bean.BillBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bill Details</title>
</head>
<body>

<h2>Bill Details</h2>

<%
    BillBean bean = (BillBean) request.getAttribute("bill");

    if(bean == null){
%>
        <h3>No matching records exists! Please try again!</h3>
<%
    } else {
%>

Bill ID: <%= bean.getBillId() %> <br><br>
Customer Name: <%= bean.getCustomerName() %> <br><br>
Product Name: <%= bean.getProductName() %> <br><br>
Bill Date: <%= bean.getBillDate() %> <br><br>
Quantity: <%= bean.getQuantity() %> <br><br>
Price: <%= bean.getPrice() %> <br><br>
Total Amount: <%= bean.getTotalAmount() %> <br><br>
Remarks: <%= bean.getRemarks() %> <br><br>

<%
    }
%>
<br>

<a href="menu.html">Go Back</a>

</body>
</html>
