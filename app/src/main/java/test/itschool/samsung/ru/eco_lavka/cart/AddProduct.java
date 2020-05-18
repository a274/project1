package test.itschool.samsung.ru.eco_lavka.cart;

public class AddProduct extends Thread {
    public CartDao cartDao;

    public AddProduct(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    @Override
    public void run() {
        synchronized (this) {
            Cart cart = new Cart();
            cart.productId = 1;
            cart.productAmount = 1;

            cartDao.insert(cart);
        }

    }
}
