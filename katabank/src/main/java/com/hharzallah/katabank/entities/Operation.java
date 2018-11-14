package com.hharzallah.katabank.entities;

import com.hharzallah.katabank.commons.Utils;
import com.hharzallah.katabank.enums.OperationType;

import java.util.Date;

public class Operation {

    private Date date;
    private double amount;
    private double balance;
    private OperationType type;

    public Operation() {
    }

    public Operation(Date date, double amount, double balance, OperationType type) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String toString(){
        return Utils.formatDate(this.date)+" "+type.getOperationType()+" "+ Utils.formatNumber(this.amount)+" Balance "+Utils.formatNumber(this.balance);
    }
}
