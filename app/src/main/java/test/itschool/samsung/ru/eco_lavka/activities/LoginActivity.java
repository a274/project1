package test.itschool.samsung.ru.eco_lavka.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.itschool.samsung.ru.eco_lavka.server_connect.TextProcessing;
import test.itschool.samsung.ru.eco_lavka.server_connect.Auth;
import test.itschool.samsung.ru.eco_lavka.R;

import static java.lang.Thread.sleep;


public class LoginActivity extends Activity implements TextProcessing {

    private String LOG_TAG = "Login";
    private TextView answer;
    private String login, password;
    private EditText log, pass;
    SharedPreferences sharedPreferences;
    final String SAVED_ID = "ID";
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

        if (isFieldEmpty(this, log, pass)) return;

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
                id = auth.resp;
                if (auth.resp == -1 || auth.resp == 0) {
                    answer.setText(R.string.login_error);
                    auth.resp = -2;
                } else {
                    saveId();
                    Intent intent = new Intent(LoginActivity.this, MainWidgets.class);
                    startActivity(intent);
                }
            }
        }
    }

    void saveId() {
        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SAVED_ID, id);
        editor.commit();
        Log.d(LOG_TAG, " id: " + id);
    }
}