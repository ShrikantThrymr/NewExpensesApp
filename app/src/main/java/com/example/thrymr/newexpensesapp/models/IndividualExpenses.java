package com.example.thrymr.newexpensesapp.models;

/**
 * Created by thrymr on 28/7/17.
 */

public class IndividualExpenses {
    private String expensesName;
    private String expensesDate;
    private String expensesStatus;
    private String totalAmount;

    @Override
    public String toString() {
        return "IndividualExpenses{" +
                "expensesName='" + expensesName + '\'' +
                ", expensesDate='" + expensesDate + '\'' +
                ", expensesStatus='" + expensesStatus + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }

    public String getExpensesName() {
        return expensesName;
    }

    public void setExpensesName(String expensesName) {
        this.expensesName = expensesName;
    }

    public String getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(String expensesDate) {
        this.expensesDate = expensesDate;
    }

    public String getExpensesStatus() {
        return expensesStatus;
    }

    public void setExpensesStatus(String expensesStatus) {
        this.expensesStatus = expensesStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
