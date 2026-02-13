package com.wipro.billing.service;

import java.util.Date;
import java.util.List;

import com.wipro.billing.bean.BillBean;
import com.wipro.billing.dao.BillDAO;

public class Administrator {
    BillDAO dao = new BillDAO();
    public String addRecord(BillBean bean) {
        String result = "FAIL";
        try {
            if (bean == null || bean.getCustomerName() == null || bean.getBillDate() == null) {
                return "INVALID INPUT";
            }
            if (bean.getCustomerName().length() < 2) {
                return "INVALID CUSTOMER NAME";
            }
            if (bean.getQuantity() < 1 || bean.getPrice() <= 0) {
                return "INVALID BILL DETAILS";
            }
            boolean exists = dao.recordExists(bean.getCustomerName(), bean.getBillDate());

            if (exists) {
                return "ALREADY EXISTS";
            }
            String billId = dao.generateBillID(bean.getCustomerName(), bean.getBillDate());
            bean.setBillId(billId);
            double total = bean.getQuantity() * bean.getPrice();
            bean.setTotalAmount(total);
            result = dao.createRecord(bean);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public BillBean viewRecord(String customerName, Date billDate) {
        BillBean bean = null;
        try {
            bean = dao.fetchRecord(customerName, billDate);
        } catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }
    public List<BillBean> viewAllRecords() {
        List<BillBean> list = null;
        try {
            list = dao.fetchAllRecords();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
