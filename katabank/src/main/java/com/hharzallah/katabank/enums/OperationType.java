package com.hharzallah.katabank.enums;

public enum OperationType {

    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal")
    ;


    private String operationType;

    OperationType() {
    }

    OperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}

