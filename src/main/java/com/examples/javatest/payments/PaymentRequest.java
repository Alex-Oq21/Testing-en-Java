package com.examples.javatest.payments;

public class PaymentRequest {
    private double amount;

    public PaymentRequest(double amount){
        this.amount = amount;
    }
    public double getAmonut(){
        return amount;
    }
}
