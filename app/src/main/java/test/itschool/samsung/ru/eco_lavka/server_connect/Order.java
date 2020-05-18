package test.itschool.samsung.ru.eco_lavka.server_connect;

import java.util.ArrayList;

import test.itschool.samsung.ru.eco_lavka.cart.Cart;

public class Order {
    private int userId;
    private ArrayList<Cart> cart;

    Order(int userId) {
        this.userId = userId;
        this.cart = new ArrayList<>();
    }
}
