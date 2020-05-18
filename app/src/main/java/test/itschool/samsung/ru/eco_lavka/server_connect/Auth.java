package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Auth extends Thread {
    private static String LOG_TAG = "MainActivity";
    private final String baseUrl = "https://server-a274.herokuapp.com/";
    public static int resp = -2;
    Account account;

    class Account {
        private String login;
        private String password;

        public Account (String login, String password) {
            this.login = login;
            this.password = password;
        }
    }

    public Auth(String login, String password) {
        account = new Account(login, password);
    }

    @Override
    public void run() {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            UserService userService = retrofit.create(UserService.class);
            Call<Integer> userCall = userService.login(account.login, account.password);

            userCall.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()) {
                        resp = response.body();
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
