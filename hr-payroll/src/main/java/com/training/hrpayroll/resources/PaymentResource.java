package com.training.hrpayroll.resources;

import com.training.hrpayroll.entities.Payment;
import com.training.hrpayroll.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private PaymentService paymentService;

    public PaymentResource(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId,
                                              @PathVariable int days){

       return ResponseEntity.ok(paymentService.getPayment(workerId, days)) ;
    }
}
