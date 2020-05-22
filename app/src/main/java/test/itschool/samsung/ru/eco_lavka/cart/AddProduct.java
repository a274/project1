package test.itschool.samsung.ru.eco_lavka.cart;

import android.util.Log;

public class AddProduct extends Thread {
    @Override
    public void run() {
        ProductDao productDao = App.getInstance().getCartDao();
        Product product = new Product();
        product.productId = 1;
        product.productAmount = 1;

        productDao.insert(product);
        Log.v("Product Add", "success");
    }
}
