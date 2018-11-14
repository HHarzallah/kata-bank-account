package com.hharzallah.katabank.services;

import com.hharzallah.katabank.commons.BankException;
import com.hharzallah.katabank.entities.Account;
import com.hharzallah.katabank.entities.Operation;
import com.hharzallah.katabank.enums.OperationType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class BankService {

    Account account = new Account(0, new Date());
    ArrayList<Operation> operations = new ArrayList<Operation>();

    public void addOperation(double amount, OperationType type) throws BankException {
        double balance = 0;
        if(amount>0){
            if(type.getOperationType().equals(OperationType.DEPOSIT.getOperationType())){
                balance = account.getBalance() + amount;
            }else if(type.getOperationType().equals(OperationType.WITHDRAWAL.getOperationType())){
                balance = account.getBalance() - amount;
                if(balance<0){
                    throw new BankException("Le montant que vous voulez retirer est supérieur à votre solde actuel");
                }
            }
            Operation operation = new Operation(new Date(),amount, balance, type);
            operations.add(operation);
            account.setBalance(balance);
        }else{
            throw new BankException("Le montant doit être supérieur à 0");
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

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }
}
