package test.itschool.samsung.ru.eco_lavka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Thread.sleep;


public class LoginActivity extends Activity {

    private static String LOG_TAG = "MainActivity";
    private final String baseUrl = "http://a274.sytes.net/php_server/";
    private TextView answer;
    private String login, password;
    private EditText log, pass;
    int id = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        //REGISTER
        TextView registerScreen = findViewById(R.id.link_to_register);
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               //Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        answer = findViewById(R.id.answer);
        log = findViewById(R.id.login);
        pass = findViewById(R.id.password);

        //LOGIN
        Button enterLogin = findViewById(R.id.btnLogin);
        enterLogin.setOnClickListener(v -> {
            sendPOST(v);



            Log.v(LOG_TAG, "response main " + id);
            if (id != -1 && id != 0) {
                Intent intent=new Intent(LoginActivity.this, MainWidgets.class);
                startActivity(intent);
            }
            else {
                answer.setText("Логин или пароль введен неверно.");
            }
        });
    }

    public void sendPOST(View view) {
        login = log.getText().toString();
        password = pass.getText().toString();
        new MyAsyncTask().execute("");
    }

    @SuppressLint("StaticFieldLeak")
    class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            UserService userService = retrofit.create(UserService.class);
            Call<Integer> userCall = userService.login(login, password);
            userCall.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()) {
                        id = response.body();
                        Log.v(LOG_TAG, "response " + id);
                    } else {
                        Log.e(LOG_TAG,"response code " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Log.e(LOG_TAG,"failure " + t);
                }
            });
            return null;
        }

    }

}