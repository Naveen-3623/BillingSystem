package com.wipro.billing.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.wipro.billing.bean.BillBean;
import com.wipro.billing.service.Administrator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    Administrator admin = new Administrator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            String operation = request.getParameter("operation");
            if (operation != null && operation.equals("newRecord")) {
                String result = addRecord(request);
                if (result.equals("FAIL") || result.equals("INVALID INPUT")) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            }
            else if (operation != null && operation.equals("viewRecord")) {
                BillBean bean = viewRecord(request);
                request.setAttribute("bill", bean);
                RequestDispatcher rd = request.getRequestDispatcher("displayBill.jsp");
                rd.forward(request, response);
            }
            else if (operation != null && operation.equals("viewAllRecords")) {
                List<BillBean> list = admin.viewAllRecords();
                request.setAttribute("billList", list);
                RequestDispatcher rd = request.getRequestDispatcher("displayAllBills.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String addRecord(HttpServletRequest request) {
        String result = "FAIL";
        try {
            BillBean bean = new BillBean();
            bean.setCustomerName(request.getParameter("customerName"));
            bean.setProductName(request.getParameter("productName"));
            String dateStr = request.getParameter("billDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            bean.setBillDate(date);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            bean.setQuantity(quantity);
            bean.setPrice(price);
            bean.setRemarks(request.getParameter("remarks"));
            result = admin.addRecord(bean);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public BillBean viewRecord(HttpServletRequest request) {
        BillBean bean = null;
        try {
            String customerName = request.getParameter("customerName");
            String dateStr = request.getParameter("billDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            bean = admin.viewRecord(customerName, date);
        } catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }
}
