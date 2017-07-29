package com.example.thrymr.newexpensesapp.models;

/**
 * Created by thrymr on 28/7/17.
 */

public class TripExpenses {
    private String tripName;
    private String tripDate;
    private String tripStatus;
    private String totalAmount;

    @Override
    public String toString() {
        return "TripExpenses{" +
                "tripName='" + tripName + '\'' +
                ", tripDate='" + tripDate + '\'' +
                ", tripStatus='" + tripStatus + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
