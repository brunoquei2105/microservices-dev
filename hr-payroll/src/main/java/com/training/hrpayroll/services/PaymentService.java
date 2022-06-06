package com.training.hrpayroll.services;

import com.training.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        Payment payment = new Payment();
        payment.setName("Bob");
        payment.setDays(days);
        payment.setDaily_Income(200.0);
        payment.setTotal(payment.getTotal());
        return payment;
    }
}
