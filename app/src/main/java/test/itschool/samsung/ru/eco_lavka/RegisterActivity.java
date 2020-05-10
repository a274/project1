package test.itschool.samsung.ru.eco_lavka;

import android.app.Activity;
import android.graphics.Color;
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

public class RegisterActivity extends Activity {
    private static String LOG_TAG = "MainActivity";
    private final String baseUrl = "http://a274.sytes.net/php_server/";
    private EditText reg_name, reg_surname, reg_email, reg_password, reg_address, reg_phonenumber;
    private String name, surname, email, password, phonenumber, address;
    private TextView answer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        reg_name = findViewById(R.id.reg_name);
        reg_surname = findViewById(R.id.reg_surname);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_address = findViewById(R.id.reg_address);
        reg_phonenumber = findViewById(R.id.reg_mobilenumber);


        // LOGIN
        TextView loginScreen = findViewById(R.id.link_to_login);
        loginScreen.setOnClickListener(v -> finish());


        //REGISTER
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this::sendPOST);
    }

    void printError(EditText editText) {
        editText.setHintTextColor(Color.RED);
        editText.setHint("Заполните поле");
    }
    public void sendPOST(View view) {
        name = reg_name.getText().toString().trim();
        surname = reg_surname.getText().toString().trim();
        email = reg_email.getText().toString();
        password = reg_password.getText().toString();
        phonenumber = reg_phonenumber.getText().toString().trim();
        address = reg_address.getText().toString().trim();

        boolean p = false;
        if (name.equals("")) {
            printError(reg_name);
            p = true;
        }
        if (surname.equals("")) {
            printError(reg_surname);
            p = true;
        }
        if (email.equals("")) {
            printError(reg_email);
            p = true;
        }
        if (password.equals("")) {
            printError(reg_password);
            p = true;
        }
        if (phonenumber.equals("")) {
            printError(reg_phonenumber);
            p = true;
        }
        if (address.equals("")) {
            printError(reg_address);
            p = true;
        }
        if (p) return;
        answer = findViewById(R.id.answer);
        new MyAsyncTask().execute("");
    }

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

            Call<User> userCall = userService
                    .register(name, surname, email, password, phonenumber, address);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        User user = response.body();
                        Log.v(LOG_TAG, "response " + user.getSurname()
                                + " " + user.getName_()
                                + " " + user.getEmail()
                                + " "  + user.getPhoneNumber()
                                + " " + user.getPassword());
                        answer.setText("Вы успешно зарегистрированны!");
                    } else {
                        answer.setText("Возникла ошибка.");
                        Log.e(LOG_TAG,"response code " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e(LOG_TAG,"failure " + t);
                }
            });
            return null;
        }

    }
}
