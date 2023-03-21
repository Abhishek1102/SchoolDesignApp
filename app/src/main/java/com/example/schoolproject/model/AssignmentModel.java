package com.example.schoolproject.model;

public class AssignmentModel {
    String subjectName;
    String title;
    String assigndate;
    String submissiondate;

    public AssignmentModel(String subjectName, String title, String assigndate, String submissiondate) {
        this.subjectName = subjectName;
        this.title = title;
        this.assigndate = assigndate;
        this.submissiondate = submissiondate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssigndate() {
        return assigndate;
    }

    public void setAssigndate(String assigndate) {
        this.assigndate = assigndate;
    }

    public String getSubmissiondate() {
        return submissiondate;
    }

    public void setSubmissiondate(String submissiondate) {
        this.submissiondate = submissiondate;
    }
}
