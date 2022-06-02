package com.example.movie_1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YtsData {

    private String status;
    @SerializedName("status_message")
    @Expose
    private String statusmessage;

    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusmessage() {
        return statusmessage;
    }

    public void setStatusmessage(String statusmessage) {
        this.statusmessage = statusmessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
