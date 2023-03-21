package com.example.schoolproject.model;

public class EventProgramModel {
    String eventTitle;
    int eventImage;
    String eventTime;
    String eventDescription;

    public EventProgramModel(String eventTitle, int eventImage, String eventTime, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventImage = eventImage;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getEventImage() {
        return eventImage;
    }

    public void setEventImage(int eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
