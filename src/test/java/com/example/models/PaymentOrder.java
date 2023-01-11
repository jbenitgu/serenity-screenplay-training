package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentOrder {

    private Integer amount;
    private String currency;
    private Buyer buyer;
    private List<Item> items = null;


}
