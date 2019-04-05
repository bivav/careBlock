package com.careblock;

public class DoctorRecordsModel {
    private String title;

    private String message;


    public DoctorRecordsModel(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public DoctorRecordsModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
