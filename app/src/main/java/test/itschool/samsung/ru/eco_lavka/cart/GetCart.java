package test.itschool.samsung.ru.eco_lavka.cart;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GetCart extends Thread {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void run() {
        ProductDao productDao = App.getInstance().getCartDao();
        products = productDao.getAll();
        Log.v("cart info", products.size() + " ");
    }
}
