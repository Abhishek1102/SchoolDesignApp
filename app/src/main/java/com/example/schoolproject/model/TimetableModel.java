package com.example.schoolproject.model;

public class TimetableModel {
    String subject;
    String duration;
    String teacher;

    public TimetableModel(String subject, String duration, String teacher) {
        this.subject = subject;
        this.duration = duration;
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}
