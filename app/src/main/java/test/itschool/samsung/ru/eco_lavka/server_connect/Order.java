package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.Product;

public class Order extends Thread {
    private int userId;
    private List<Product> product;

    private static String LOG_TAG = "Order info";

    public Order(int userId, List<Product> product) {
        this.userId = userId;
        this.product = product;
        //this.product = new ArrayList<>();
    }

    @Override
    public void run() {
        UserService userService = App.getInstance().getUserService();
        Call<Integer> userCall = userService.makeOrder(this);

        userCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int resp = response.body();
                    Log.v(LOG_TAG, "response " + resp);
                } else {
                    Log.e(LOG_TAG, "response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(LOG_TAG, "failure " + t);
            }
        });
    }
}
