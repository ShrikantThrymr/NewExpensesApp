package com.example.thrymr.newexpensesapp.models;

/**
 * Created by thrymr on 28/7/17.
 */

public class AdminTrip {
    private String empName;
    private String empId;
    private String tripName;
    private String tripDate;
    private String totalAmount;
    private String tripStatus;

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "AdminTrip{" +
                "empName='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                ", tripName='" + tripName + '\'' +
                ", tripDate='" + tripDate + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", tripStatus='" + tripStatus + '\'' +
                '}';
    }
}
