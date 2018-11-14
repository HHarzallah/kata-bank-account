package com.hharzallah.katabank.services;

import com.hharzallah.katabank.commons.Utils;
import com.hharzallah.katabank.entities.Account;
import com.hharzallah.katabank.entities.Operation;
import com.hharzallah.katabank.enums.OperationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class BankService {

    Account account = new Account(0, new Date());
    ArrayList<Operation> operations = new ArrayList<Operation>();

    public void deposit(double amount){
        if(amount>0){
            double balance = account.getBalance() + amount;
            Operation operation = new Operation(new Date(),amount, balance, OperationType.DEPOSIT);
            operations.add(operation);
            account.setBalance(balance);
            account.setDate(new Date());
            System.out.println(operation.toString());
        }else{
            System.out.println("Le montant doit être supérieur à 0");
        }
    }

    public void withdrawal(double amount){
        if(amount>0){
        double balance = account.getBalance() - amount;
        if(balance>=0){
            Operation operation = new Operation(new Date(),amount, balance, OperationType.WITHDRAWAL);
            operations.add(operation);
            account.setBalance(balance);
            account.setDate(new Date());
            System.out.println(operation.toString());
        }else{
            System.out.println("Le montant que vous voulez retirer est supérieur à votre solde actuel");
        }
        }else{
            System.out.println("Le montant doit être supérieur à 0");
        }
    }

    public void showHistory(){
        Iterator<Operation> op =operations.iterator();
        while (op.hasNext()){
            System.out.println(op.next().toString());
        }
    }

    public Account getAccount() {
        return account;
    }
}
