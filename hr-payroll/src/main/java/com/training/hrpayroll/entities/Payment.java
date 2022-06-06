package com.training.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -2658781741320075209L;

    private String name;
    private double daily_Income;
    private Integer days;
    private double total;

    public double getTotal(){
        return this.days * this.daily_Income;
    }

}
