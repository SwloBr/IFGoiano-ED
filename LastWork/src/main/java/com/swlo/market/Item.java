package com.swlo.market;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private String name;
    private float price;
    private int stock;


}
