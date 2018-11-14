package com.hharzallah.katabank;

import com.hharzallah.katabank.entities.Account;
import com.hharzallah.katabank.entities.Operation;
import com.hharzallah.katabank.services.BankService;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankTest {

    BankService bankService;
    Account account;

    @Before
    public void setUp(){
        bankService = new BankService();
        account = bankService.getAccount();
    }

    @Test
    public void checkNotNegativeDeposit(){
        bankService.deposit(-100);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void checkNotNegativeWithdrawal(){
        bankService.withdrawal(-10);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void checkDeposit(){
        bankService.deposit(12.50);
        bankService.deposit(14);
        assertEquals(26.50, account.getBalance());
    }

    @Test
    public void checkWithdrawalBalanceNegative(){
        bankService.getAccount().setBalance(11);
        bankService.withdrawal(15);
        assertEquals(11.0, account.getBalance());
    }

    @Test
    public void checkWithdrawalBalancePositive(){
        bankService.getAccount().setBalance(45);
        bankService.withdrawal(11);
        assertEquals(34.0, account.getBalance());
    }

    @Test
    public void checkOperations(){
        bankService.getAccount().setBalance(0);
        bankService.deposit(12);
        bankService.withdrawal(10);
        bankService.deposit(5);
        assertEquals(7.0, account.getBalance());
    }

}
