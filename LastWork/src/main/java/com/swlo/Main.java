package com.swlo;


import com.swlo.market.Cart;
import com.swlo.market.Item;
import com.swlo.market.ItemToCart;
import com.swlo.market.Shop;

import java.util.Scanner;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static Shop shop = new Shop();

    public static void main(String[] args) {


        while (true) {
            System.out.println("""
                    \n
                    Commands:
                    user - create a cart
                    admin - enter in admin panel
                                        
                    Enter command:""");

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("admin")) {
                adminPanel();
            } else if (command.equalsIgnoreCase("user")) {
                userPanel();
            } else if ((command.equalsIgnoreCase("exit"))) {
                return;
            } else {
                System.out.println("Unknown command: " + command);
            }
        }

    }


    private static void userPanel() {

        Cart cart = new Cart(shop);

        while (true) {

            System.out.println("""
                    \n
                    Commands:
                                            
                    add <name> <quantity>
                    remove <name>
                    update <name> <quantity>
                    sort <name/price/stock> <products/cart>
                    list <products/cart>
                    exit
                                            
                    """);

            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.startsWith("add ")) {
                String[] parts = command.split(" ");
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                Item item = shop.getItemByName(name);
                if (item != null) {
                    boolean added = cart.addProduct(item, quantity);

                    System.out.println((added) ? "Product added to cart" + name + " x" + quantity : "Product not found: " + name);

                } else {
                    System.out.println("Product not found: " + name);
                }


            } else if (command.startsWith("remove ")) {
                String name = command.split(" ")[1];
                Item item = shop.getItemByName(name);
                if (item != null) {
                    ItemToCart itemToCart = cart.getItemCartByItem(item);
                    int quantity = itemToCart.getQuantity();

                    boolean removed = cart.removeProduct(itemToCart);

                    System.out.println((removed) ? "Product remove by cart" + name + " x" + quantity : "Product " + name + "  not in cart");

                } else {
                    System.out.println("Product not found: " + name);
                }

            } else if (command.startsWith("update ")) {
                String[] parts = command.split(" ");
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                Item item = shop.getItemByName(name);
                if (item != null) {
                    ItemToCart itemToCart = cart.getItemCartByItem(item);

                    boolean updated = cart.updateItemToCart(itemToCart, quantity);


                    System.out.println((updated) ? ((quantity == 0) ? "Product remove by cart" + name : "Product  updated" + name + " x" + quantity) : "Product " + name + "  not in cart");


                } else {
                    System.out.println("Product not found: " + name);
                }
            } else if (command.startsWith("list")) {

                String[] parts = command.split(" ");
                String function = parts[1];
                if (function.equalsIgnoreCase("products")) {
                    System.out.println(" ITEM | PRICE | QUANTITY");
                    for (Item item : shop.getProducts()) {
                        System.out.println(item.getName() + ": " + item.getPrice() + ", " + item.getStock());
                    }
                } else if (function.equalsIgnoreCase("cart")) {

                    System.out.println(" ITEM | PRICE | QUANTITY");
                    for (ItemToCart itemToCart : cart.getCartProducts()) {
                        if (itemToCart.getItem() != null) {
                            System.out.println(itemToCart.getItem().getName() + ": " + itemToCart.getItem().getPrice() + ", " + itemToCart.getQuantity());
                        }
                    }

                } else {
                    System.out.println("Unknown argument: " + function);
                }

            } else if (command.startsWith("sort")) {
                String[] parts = command.split(" ");
                String function = parts[1];
                String which = parts[2];

                if (function != "name" || function != "price" || function != "stock") {
                    System.out.println("Unknown command: " + function);
                } else if (which.equalsIgnoreCase("products")) {
                    if (function.equalsIgnoreCase("name")) {
                        shop.sortProductsByName();
                    } else if (function.equalsIgnoreCase("price")) {
                        shop.sortProductsByPrice();
                    } else if (function.equalsIgnoreCase("stock")) {
                        shop.sortProductsByStock();
                    }
                    System.out.println("Sorted");
                } else if (which.equalsIgnoreCase("cart")) {
                    if (function.equalsIgnoreCase("name")) {
                        cart.sortCartByName();
                    } else if (function.equalsIgnoreCase("price")) {
                        cart.sortCartByPrice();
                    } else if (function.equalsIgnoreCase("stock")) {
                        cart.sortCartByStock();
                    }
                    System.out.println("Sorted");
                } else {
                    System.out.println("Unknown command: " + which);
                }


            } else if (command.equals("exit")) {
                return;
            } else {
                System.out.println("Unknown command: " + command);
            }
        }


    }

    private static void adminPanel() {

        while (true) {

            System.out.println("""
                    \n
                    Commands:
                                            
                    add <name> <price> <stock>
                    remove <name>
                    update <name> <price> <stock>
                    sort <name/price/stock>
                    list
                    exit
                                            
                    """);

            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.startsWith("add ")) {
                String[] parts = command.split(" ");
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                int stock = Integer.parseInt(parts[3]);
                Item item = Item.builder().name(name).price(price).stock(stock).build();
                shop.addProduct(item);
                System.out.println("Added product: " + name);


            } else if (command.startsWith("remove ")) {
                String name = command.split(" ")[1];
                Item item = shop.getItemByName(name);
                if (item != null) {
                    shop.removeProduct(item);
                    System.out.println("Removed product: " + name);
                } else {
                    System.out.println("Product not found: " + name);
                }
            } else if (command.startsWith("update ")) {
                String[] parts = command.split(" ");
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                int stock = Integer.parseInt(parts[3]);
                Item item = shop.getItemByName(name);
                if (item != null) {
                    shop.updateProduct(item, stock, price);
                    System.out.println("Updated product: " + name);
                } else {
                    System.out.println("Product not found: " + name);
                }
            } else if (command.equals("list")) {

                System.out.println(" ITEM | PRICE | QUANTITY");
                for (Item item : shop.getProducts()) {
                    System.out.println(item.getName() + ": " + item.getPrice() + ", " + item.getStock());
                }


            } else if (command.startsWith("sort")) {
                String[] parts = command.split(" ");
                String function = parts[1];
                if (function.equalsIgnoreCase("name")) {
                    shop.sortProductsByName();
                } else if (function.equalsIgnoreCase("price")) {
                    shop.sortProductsByPrice();
                } else if (function.equalsIgnoreCase("stock")) {
                    shop.sortProductsByStock();
                }

                System.out.println("Sorted");


            } else if (command.equals("exit")) {
                return;
            } else {
                System.out.println("Unknown command: " + command);
            }
        }

    }

}



