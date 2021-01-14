package com.examples.javatest.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
