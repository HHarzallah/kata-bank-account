package com.hharzallah.katabank.entities;

import java.util.Date;

public class Account {

    private double balance;
    private Date date;

    public Account() {
    }

    public Account(double balance, Date date) {
        this.balance = balance;
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
