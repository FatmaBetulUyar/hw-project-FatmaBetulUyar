package com.patika.paycore.Project.exception;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException() {
        super("Sorry,your transaction could not be performed.You do not have enough balance in your account. ");
    }
}
