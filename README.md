📘 Project : Billing Management System
📌 Project Description :

The Billing Management System is a web-based Java application developed using:

Java (Servlet & JSP)

JDBC

Oracle Database

HTML

This project allows users to:

Add a new bill record

View a single bill record

View all bill records

It follows a layered architecture:

JSP → Servlet → Service → DAO → Database

🔄 Application Flow :
➤ Add Bill

User fills form in addBill.jsp

Data goes to MainServlet

Servlet creates BillBean

Administrator validates input

DAO inserts data into database

Redirects to success or error page

➤ View Single Record

User enters customer name and date

Servlet calls service

DAO fetches record

Data is forwarded to displayBill.jsp

➤ View All Records

Servlet calls service

DAO fetches all records

List is forwarded to displayAllBills.jsp

🛠️ Technologies Used :

Java

Servlet (Jakarta)

JSP

JDBC

Oracle Database

HTML

🎯 Key Concepts Used :

MVC Architecture

Bean Class

DAO Pattern

Sequence in Oracle

RequestDispatcher

Exception Handling (try-catch)

Date Conversion (String → java.util.Date → java.sql.Date)

🚀 How to Run :

Import project into Eclipse

Configure Apache Tomcat Server

Setup Oracle database

Create table and sequence

Run project on server
