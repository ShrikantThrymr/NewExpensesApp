package com.example.thrymr.newexpensesapp.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thrymr on 28/7/17.
 */

public class TripModel implements Serializable {
    private int tripId;
    private String tripArea;
    private String tripDate;
    private String tripStatus;
    private String costOfMoney;
    private List<TripIndividualModel> listOfChild;

    public TripModel(int tripId, String tripArea, String tripDate, String tripStatus, String costOfMoney) {
        this.tripId = tripId;
        this.tripArea = tripArea;
        this.tripDate = tripDate;
        this.tripStatus = tripStatus;
        this.costOfMoney = costOfMoney;

    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTripArea() {
        return tripArea;
    }

    public void setTripArea(String tripArea) {
        this.tripArea = tripArea;
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
    public List<TripIndividualModel> getListOfChild() {
        return listOfChild;
    }

    public void setListOfChild(List<TripIndividualModel> listOfChild) {
        this.listOfChild = listOfChild;
    }
}
