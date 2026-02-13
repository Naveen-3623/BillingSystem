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

Output :

<img width="553" height="355" alt="image" src="https://github.com/user-attachments/assets/287acc85-b848-4ce7-9365-c589d65d5f1f" />

<img width="588" height="513" alt="image" src="https://github.com/user-attachments/assets/0957b723-80bf-4a92-80a7-bb85aa5b053d" />

<img width="551" height="232" alt="image" src="https://github.com/user-attachments/assets/cc8d8216-4c69-4cfa-a53c-920521a47ba6" />

<img width="552" height="285" alt="image" src="https://github.com/user-attachments/assets/8d344703-6448-4d3c-830f-ddbd0de89cf2" />

<img width="600" height="581" alt="image" src="https://github.com/user-attachments/assets/b5beced6-fdab-4bd2-9a34-2a4b5170c270" />

<img width="542" height="189" alt="image" src="https://github.com/user-attachments/assets/c25c14ac-bfd6-43ac-af8c-ab99d9bff303" />

<img width="783" height="391" alt="image" src="https://github.com/user-attachments/assets/feaa73f0-1b54-4786-aa66-d730777b4bc5" />







