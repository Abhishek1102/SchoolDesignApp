package com.example.schoolproject.model;

public class FeesDueModel {
    String receiptNo;
    String month;
    String paymentDate;
    String payMode;
    String totalPendingAmount;
    String totalamount;
    String payDownload;
    int iv_feesdue;

    public FeesDueModel(String receiptNo, String month, String paymentDate, String payMode, String totalPendingAmount, String totalamount, String payDownload, int iv_feesdue) {
        this.receiptNo = receiptNo;
        this.month = month;
        this.paymentDate = paymentDate;
        this.payMode = payMode;
        this.totalPendingAmount = totalPendingAmount;
        this.totalamount = totalamount;
        this.payDownload = payDownload;
        this.iv_feesdue = iv_feesdue;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getTotalPendingAmount() {
        return totalPendingAmount;
    }

    public void setTotalPendingAmount(String totalPendingAmount) {
        this.totalPendingAmount = totalPendingAmount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getPayDownload() {
        return payDownload;
    }

    public void setPayDownload(String payDownload) {
        this.payDownload = payDownload;
    }

    public int getIv_feesdue() {
        return iv_feesdue;
    }

    public void setIv_feesdue(int iv_feesdue) {
        this.iv_feesdue = iv_feesdue;
    }
}
