package test.itschool.samsung.ru.eco_lavka.cart;

public class DeleteProduct extends Thread {
    private long productId;

    public DeleteProduct(long productId) {
        this.productId = productId;
    }
    @Override
    public void run() {
        synchronized (this) {
            ProductDao productDao = App.getInstance().getCartDao();
            Product deletingProduct = productDao.getById(productId);
            productDao.delete(deletingProduct);
        }
    }
}
