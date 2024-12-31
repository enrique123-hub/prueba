package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeCommand {

    private String name;

    private String details;

    private String code;

    private Double price;

    private String supplierId;
    
}