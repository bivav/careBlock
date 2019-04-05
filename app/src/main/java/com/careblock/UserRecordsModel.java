package com.careblock;

import java.util.ArrayList;

public class UserRecordsModel {

    private String title;

    private String message, name, record;


    public UserRecordsModel(String title, String message, String name, String record) {
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

    public UserRecordsModel() {

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
