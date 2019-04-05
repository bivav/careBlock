package com.careblock;

public class DoctorRecordsModel {
    private String title;

    private String message, name, record;

    public DoctorRecordsModel(String title, String message, String name, String record) {
        this.title = title;
        this.message = message;
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public String getRecord() {
        return record;
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
