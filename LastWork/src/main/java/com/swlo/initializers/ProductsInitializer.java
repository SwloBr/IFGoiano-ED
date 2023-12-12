package com.swlo.initializers;

import com.swlo.market.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsInitializer {

    @Getter
    private static List<Item> products = new ArrayList<>(Arrays.asList(
            Item.builder()
                    .name("Nokia_Tijolao")
                    .price(23)
                    .stock(19)
                    .build(),
            Item.builder()
                    .name("Frivaca_fibe")
                    .price(59)
                    .stock(30)
                    .build(),
            Item.builder()
                    .name("Digerante_Leron")
                    .price(23)
                    .stock(19)
                    .build(),
            Item.builder()
                    .name("Legion_9i")
                    .price(15000)
                    .stock(3)
                    .build(),
            Item.builder()
                    .name("SuperLight_X_PRO_G")
                    .price(634)
                    .stock(8)
                    .build()

    ));

}
