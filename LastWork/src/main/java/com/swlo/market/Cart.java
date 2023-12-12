package com.swlo.market;

import com.swlo.utils.Sort;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cart {


    private final Shop shop;
    @Getter
    private List<ItemToCart> cartProducts = new ArrayList<>();

    public Cart(Shop shop) {
        this.shop = shop;
    }

    public float getPrice() {
        float price = 0;
        for (ItemToCart cartProduct : cartProducts) {
            Item item = cartProduct.getItem();
            int quantity = cartProduct.getQuantity();

            price += (item.getPrice() * quantity);
        }
        return price;
    }

    public boolean addProduct(Item item, int quantity) {

        if (quantity == 0) {
            return false;
        }

        if (item.getStock() >= quantity) {
            cartProducts.add(new ItemToCart(item, quantity));
            shop.updateProductQuantity(item, item.getStock() - quantity);
            return true;
        }
        return false;
    }

    public boolean removeProduct(ItemToCart itemCart) {

        Item item = itemCart.getItem();
        int quantity = itemCart.getQuantity();

        cartProducts.remove(itemCart);
        shop.updateProductQuantity(item, item.getStock() + quantity);

        return true;
    }

    public boolean removeProduct(Item item) {


        ItemToCart itemToCart = getItemCartByItem(item);

        if (itemToCart == null) {
            return false;
        }

        int quantity = itemToCart.getQuantity();

        cartProducts.remove(itemToCart);
        shop.updateProductQuantity(item, item.getStock() + quantity);

        return true;
    }

    public ItemToCart getItemCartByItem(Item item) {

        for (ItemToCart cartProduct : cartProducts) {
            if (cartProduct.getItem().equals(item)) {
                return cartProduct;
            }

        }
        return null;

    }

    public boolean updateItemToCart(ItemToCart itemToCart, int quantity) {
        int actualQuantity = itemToCart.getQuantity();
        Item item = itemToCart.getItem();


        if (itemToCart == null) {
            return false;
        }

        if (actualQuantity == quantity) {
            return true;
        }

        if (quantity == 0) {

            return (removeProduct(itemToCart));
        }

        if (actualQuantity > quantity) {

            shop.updateProductQuantity(item, item.getStock() + actualQuantity - quantity);
        } else {
            shop.updateProductQuantity(item, item.getStock() - quantity);
        }

        itemToCart.setQuantity(quantity);

        return true;


    }


    public void clearCart() {

        cartProducts.clear();
    }


    public void sortCartByPrice() {
        List<ItemToCart> sortedList = new ArrayList<>(cartProducts);
        Sort.bubbleSort(sortedList, Comparator.comparing(itemToCart -> itemToCart.getItem().getPrice()));
        cartProducts = sortedList;
    }

    public void sortCartByName() {
        List<ItemToCart> sortedList = new ArrayList<>(cartProducts);
        Sort.selectionSort(sortedList, Comparator.comparing(itemToCart -> itemToCart.getItem().getName()));
        cartProducts = sortedList;
    }

    public void sortCartByStock() {
        List<ItemToCart> sortedList = new ArrayList<>(cartProducts);
        Sort.insertionSort(sortedList, Comparator.comparing(ItemToCart::getQuantity));
        cartProducts = sortedList;
    }


    public void checkout() {

        clearCart();
    }
}
