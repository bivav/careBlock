package com.careblock;

import java.util.ArrayList;

public class UserRecordsModel {

    private String title;

    private String message;


    public UserRecordsModel(String title, String message) {
        this.title = title;
        this.message = message;
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
