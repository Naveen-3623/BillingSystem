package com.wipro.billing.dao;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.billing.bean.BillBean;
import com.wipro.billing.util.DBUtil;

public class BillDAO {
    public String createRecord(BillBean bean) {
        String result = "FAIL";
        try {
            Connection con = DBUtil.getDBConnection();
            String sql = "INSERT INTO BILL_TB VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getBillId());
            ps.setString(2, bean.getCustomerName());
            ps.setString(3, bean.getProductName());
            ps.setDate(4, new java.sql.Date(bean.getBillDate().getTime()));
            ps.setInt(5, bean.getQuantity());
            ps.setDouble(6, bean.getPrice());
            ps.setDouble(7, bean.getTotalAmount());
            ps.setString(8, bean.getRemarks());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = bean.getBillId();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public boolean recordExists(String customerName, Date billDate) {
        boolean status = false;
        try {
            Connection con = DBUtil.getDBConnection();
            String sql = "SELECT * FROM BILL_TB WHERE CUSTOMERNAME=? AND BILL_DATE=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(billDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public String generateBillID(String customerName, Date billDate) {
        String billId = "";
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT BILL_SEQ.NEXTVAL FROM DUAL");
            int seq = 0;
            if (rs.next()) {
                seq = rs.getInt(1);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String datePart = sdf.format(billDate);
            String namePart = customerName.substring(0, 2).toUpperCase();
            billId = datePart + namePart + seq;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return billId;
    }

    public BillBean fetchRecord(String customerName, Date billDate) {
        BillBean bean = null;
        try {
            Connection con = DBUtil.getDBConnection();
            String sql = "SELECT * FROM BILL_TB WHERE CUSTOMERNAME=? AND BILL_DATE=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(billDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bean = new BillBean();
                bean.setBillId(rs.getString("BILLID"));
                bean.setCustomerName(rs.getString("CUSTOMERNAME"));
                bean.setProductName(rs.getString("PRODUCTNAME"));
                bean.setBillDate(rs.getDate("BILL_DATE"));
                bean.setQuantity(rs.getInt("QUANTITY"));
                bean.setPrice(rs.getDouble("PRICE"));
                bean.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                bean.setRemarks(rs.getString("REMARKS"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }

    public List<BillBean> fetchAllRecords() {
        List<BillBean> list = new ArrayList<BillBean>();
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM BILL_TB");
            while (rs.next()) {
                BillBean bean = new BillBean();
                bean.setBillId(rs.getString("BILLID"));
                bean.setCustomerName(rs.getString("CUSTOMERNAME"));
                bean.setProductName(rs.getString("PRODUCTNAME"));
                bean.setBillDate(rs.getDate("BILL_DATE"));
                bean.setQuantity(rs.getInt("QUANTITY"));
                bean.setPrice(rs.getDouble("PRICE"));
                bean.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                bean.setRemarks(rs.getString("REMARKS"));
                list.add(bean);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
