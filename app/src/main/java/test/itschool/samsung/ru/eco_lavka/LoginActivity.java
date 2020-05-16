package test.itschool.samsung.ru.eco_lavka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
    private TextView answer;
    private String login, password;
    private EditText log, pass;
    int id = 0;
    // -2 -> response hasn't come yet
    // -1 -> connection problems, wrong data
    // 0 -> wrong data
    // any other number -> user id

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //REGISTER
        TextView registerScreen = findViewById(R.id.link_to_register);
        registerScreen.setOnClickListener(v -> {
           //Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        });

        answer = findViewById(R.id.answer);
        log = findViewById(R.id.login);
        pass = findViewById(R.id.password);

        //LOGIN
        Button enterLogin = findViewById(R.id.btnLogin);
        enterLogin.setOnClickListener(this::sendPOST);
    }

    public void sendPOST(View view) {
        login = log.getText().toString().trim();
        password = pass.getText().toString().trim();

        if (isFieldEmpty()) return;

        answer.setText(null);
        new SetAnswer();
        answer.setHint("waiting..");
        Thread thread = new Thread(new SetAnswer());
        thread.start();
    }

    public class SetAnswer implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                Auth auth = new Auth(login, password);
                auth.start();
                while (auth.resp == -2) {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {}
                }
                if (auth.resp == -1 || auth.resp == 0) {
                    answer.setText(R.string.login_error);
                    auth.resp = -2;
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainWidgets.class);
                    startActivity(intent);
                }
            }
        }
    }

    public void printError(EditText editText) {
        editText.setHintTextColor(getResources().getColor(R.color.error));
        editText.setHint(R.string.fill_the_field);
    }

    public boolean isFieldEmpty () {
        boolean p = false;
        if (login.equals("")) {
            printError(log);
            p = true;
        }
        if (password.equals("")) {
            printError(pass);
            p = true;
        }
        return p;
    }
}