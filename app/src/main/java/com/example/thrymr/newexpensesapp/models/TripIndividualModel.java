package com.example.thrymr.newexpensesapp.models;

/**
 * Created by thrymr on 28/7/17.
 */

public class TripIndividualModel {
    private int tripId;
    private String vichicalType;
    private String tripDate;
    private String tripStatus;
    private String costOfMoney;
    private int parentTripId;

    public TripIndividualModel(int tripId, String vichicalType, String tripDate, String tripStatus, String costOfMoney, int parentTripId) {
        this.tripId = tripId;
        this.vichicalType = vichicalType;
        this.tripDate = tripDate;
        this.tripStatus = tripStatus;
        this.costOfMoney = costOfMoney;
        this.parentTripId=parentTripId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getVichicalType() {
        return vichicalType;
    }

    public void setVichicalType(String vichicalType) {
        this.vichicalType = vichicalType;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getCostOfMoney() {
        return costOfMoney;
    }

    public void setCostOfMoney(String costOfMoney) {
        this.costOfMoney = costOfMoney;
    }
    public int getParentTripId() {
        return parentTripId;
    }

    public void setParentTripId(int parentTripId) {
        this.parentTripId = parentTripId;
    }
}
