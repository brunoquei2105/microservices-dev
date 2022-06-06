package com.training.hrpayroll.entities;

import lombok.Data;

import java.io.Serializable;

@Data

public class Worker implements Serializable {

    private static final long serialVersionUID = 7483778393166659265L;


    private Long id;
    private String name;
    private double daily_Income;

}
