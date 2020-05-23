package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.App;

public class Registration extends Thread {
    private static String LOG_TAG = "REGISTER";
    public static int responseCode = -3;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone_number;
    private String address;

    public Registration(String name, String surname, String email, String password, String phone_number, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }

    @Override
    public void run() {
        UserService userService = App.getInstance().getUserService();

        Call<Integer> userCall = userService
                .register(name, surname, email, password, phone_number, address);


        try {
            userCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Callback<Integer> callback = new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    responseCode = response.body();
                    Log.v(LOG_TAG, "response " + response.body());

                } else {
                    //answer.setHint(R.string.reg_error);
                    Log.e(LOG_TAG,"response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(LOG_TAG,"failure " + t);
            }
        };

        userCall.enqueue(callback);

    }
}
