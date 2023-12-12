package com.swlo.market;

import com.swlo.initializers.ProductsInitializer;
import com.swlo.utils.Sort;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Shop {

    private List<Item> products = ProductsInitializer.getProducts();
    private String currentSorting;

    public void sortProductsByPrice() {
        List<Item> sortedList = new ArrayList<>(products);
        Sort.bubbleSort(sortedList, Comparator.comparing(Item::getPrice));
        products = sortedList;
        currentSorting = "price";
    }

    public void sortProductsByName() {
        List<Item> sortedList = new ArrayList<>(products);
        Sort.selectionSort(sortedList, Comparator.comparing(Item::getName));
        products = sortedList;
        currentSorting = "name";
    }

    public void sortProductsByStock() {
        List<Item> sortedList = new ArrayList<>(products);
        Sort.insertionSort(sortedList, Comparator.comparing(Item::getStock));
        products = sortedList;
        currentSorting = "stock";
    }

    public void addProduct(Item item) {

            products.add(item);
    }

    public void removeProduct(Item item) {
            products.remove(item);
    }

    public void updateProduct(Item item, int newQuantity, float newPrice) {
        for (Item product : products) {
            if (product.equals(item)) {
                product.setStock(newQuantity);
                product.setPrice(newPrice);
            }
        }
    }

    public void updateProductQuantity(Item item, int newQuantity) {
        for (Item product : products) {
            if (product.equals(item)) {
                product.setStock(newQuantity);
            }
        }
    }

    public void updateProductPrice(Item item, float newPrice) {
        for (Item product : products) {
            if (product.equals(item)) {
                product.setPrice(newPrice);
            }
        }
    }

    public Item getItemByName(String name) {
        for (Item product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }



}
