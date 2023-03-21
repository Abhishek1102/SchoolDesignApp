package com.example.schoolproject.model;

public class HolidayModel {
    String holdiayName;
    String holidayDate;
    String holidayDay;

    public HolidayModel(String holdiayName, String holidayDate, String holidayDay) {
        this.holdiayName = holdiayName;
        this.holidayDate = holidayDate;
        this.holidayDay = holidayDay;
    }

    public String getHoldiayName() {
        return holdiayName;
    }

    public void setHoldiayName(String holdiayName) {
        this.holdiayName = holdiayName;
    }

    public String getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(String holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayDay() {
        return holidayDay;
    }

    public void setHolidayDay(String holidayDay) {
        this.holidayDay = holidayDay;
    }
}
