package com.training.hrpayroll.services;

import com.training.hrpayroll.entities.Payment;
import com.training.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.UriBuilder;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String hrWorkerURI;

    public Payment getPayment(long workerId, int days){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);


        Worker worker =
                restTemplate.exchange(UriBuilder.fromPath(hrWorkerURI).build(workerId), HttpMethod.GET, entity, Worker.class).getBody();

        Payment payment = new Payment();

        assert worker != null;
        payment.setName(worker.getName());
        payment.setDays(days);
        payment.setDaily_Income(worker.getDaily_Income());
        payment.setTotal(payment.getTotal());
        return payment;
    }
}
