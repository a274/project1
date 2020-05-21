package test.itschool.samsung.ru.eco_lavka.cart;

import android.util.Log;

import java.util.List;

public class GetCart implements Runnable {
    @Override
    public void run() {
        // CART CREATING
        ProductDao productDao = App.getInstance().getCartDao();

        // BUTTON ADD PRODUCT
        List <Product> products = productDao.getAll();
        for (int i = 0; i < productDao.getAll().size(); i++) {
            Log.v("cart", products.get(i).productAmount + " ");
        }
    }
}
