package test.itschool.samsung.ru.eco_lavka.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import test.itschool.samsung.ru.eco_lavka.R;
public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    final String SAVED_ID = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        int id = sharedPreferences.getInt(SAVED_ID, 0);
        synchronized (this) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (id > 0) {
                Intent intent = new Intent(MainActivity.this, MainWidgets.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }
    }
}
