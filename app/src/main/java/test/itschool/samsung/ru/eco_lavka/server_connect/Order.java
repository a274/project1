package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.Cart;

public class Order extends Thread {
    private int userId;
    private ArrayList<Cart> cart;

    private static String LOG_TAG = "Order info";

    Order(int userId) {
        this.userId = userId;
        this.cart = new ArrayList<>();
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
