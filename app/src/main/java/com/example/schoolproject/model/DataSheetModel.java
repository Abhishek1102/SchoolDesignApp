package com.example.schoolproject.model;

public class DataSheetModel {
    String date;
    String day;
    String month;
    String subject;
    String time;

    public DataSheetModel(String date, String day, String month, String subject, String time) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.subject = subject;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
