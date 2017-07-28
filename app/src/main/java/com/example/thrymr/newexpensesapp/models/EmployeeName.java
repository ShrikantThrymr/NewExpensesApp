package com.example.thrymr.newexpensesapp.models;

/**
 * Created by shrikant on 28/7/17.
 */

public class EmployeeName {
    private String empId;
    private String empName;
    private String empImage;

    @Override
    public String toString() {
        return "EmployeeName{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empImage='" + empImage + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }
}
