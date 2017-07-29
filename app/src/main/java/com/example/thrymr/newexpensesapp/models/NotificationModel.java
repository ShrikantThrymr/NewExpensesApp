package com.example.thrymr.newexpensesapp.models;

/**
 * Created by thrymr on 28/7/17.
 */

public class NotificationModel {
    private int notificationId;
    private String notificationName;
    private String notificationDate;
    private String notificationStatus;

    public NotificationModel(int notificationId, String notificationName, String notificationDate, String notificationStatus) {
        this.notificationId = notificationId;
        this.notificationName = notificationName;
        this.notificationDate = notificationDate;
        this.notificationStatus = notificationStatus;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}
