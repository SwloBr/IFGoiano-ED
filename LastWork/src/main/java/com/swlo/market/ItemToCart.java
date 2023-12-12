package com.swlo.market;

import lombok.Data;
import lombok.Getter;

@Data
public class ItemToCart {

    @Getter
    private Item item;
    private int quantity;


    public ItemToCart(Item item, int quantity) {
    }


    public float getPrice() {
        return item.getPrice();
    }

    public String getName() {
        return item.getName();
    }
}
