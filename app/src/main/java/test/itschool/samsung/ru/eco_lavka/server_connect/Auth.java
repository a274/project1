package test.itschool.samsung.ru.eco_lavka.server_connect;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.itschool.samsung.ru.eco_lavka.cart.App;

public class Auth extends Thread {
    private String LOG_TAG = "Auth";
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
        UserService userService = App.getInstance().getUserService();

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
