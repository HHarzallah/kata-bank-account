package com.hharzallah.katabank;

import com.hharzallah.katabank.commons.BankException;
import com.hharzallah.katabank.entities.Account;
import com.hharzallah.katabank.entities.Operation;
import com.hharzallah.katabank.enums.OperationType;
import com.hharzallah.katabank.services.BankService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class BankTest {

    BankService bankService;
    Account account;
    final ByteArrayOutputStream systemOut = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;

    @Before
    public void setUp(){
        bankService = new BankService();
        account = bankService.getAccount();
        System.setOut(new PrintStream(systemOut));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);

    }

    @Test
    public void checkNotNegativeDeposit(){
        try{
            bankService.addOperation(-100, OperationType.DEPOSIT);
        }catch (BankException e){
            e.printStackTrace();
        }
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void checkNotNegativeWithdrawal(){
        try {
            bankService.addOperation(-10, OperationType.WITHDRAWAL);
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void checkBalanceAfterDeposit(){
        try {
            bankService.addOperation(12.50, OperationType.DEPOSIT);
            bankService.addOperation(14, OperationType.DEPOSIT);
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(26.50, account.getBalance());
    }

    @Test
    public void checkWithdrawalBalanceNegative(){
        bankService.getAccount().setBalance(11);
        try{
            bankService.addOperation(15, OperationType.WITHDRAWAL);
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(11.0, account.getBalance());
    }

    @Test
    public void checkWithdrawalBalancePositive(){
        bankService.getAccount().setBalance(45);
        try {
            bankService.addOperation(11, OperationType.WITHDRAWAL);
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(34.0, account.getBalance());
    }

    @Test
    public void checkBalanceAfterOperations(){
        bankService.getAccount().setBalance(0);
        try{
            bankService.addOperation(12, OperationType.DEPOSIT);
            bankService.addOperation(10, OperationType.WITHDRAWAL);
            bankService.addOperation(5, OperationType.DEPOSIT);
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(7.0, account.getBalance());
    }

    @Test
    public void checkOperationsHistory(){
        bankService.setOperations( new ArrayList<Operation>());
        try{
            bankService.addOperation(1200, OperationType.DEPOSIT);
            bankService.showHistory();
        } catch (BankException e) {
            e.printStackTrace();
        }
        assertEquals(bankService.getOperations().get(0).toString()+"\r\n", systemOut.toString());
    }
}
