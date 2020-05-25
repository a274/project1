package test.itschool.samsung.ru.eco_lavka.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.CartActivity;

import static test.itschool.samsung.ru.eco_lavka.R.id.imageView;
import static test.itschool.samsung.ru.eco_lavka.R.layout.main_widgets;
import static test.itschool.samsung.ru.eco_lavka.R.layout.menu_categories;

public class MainWidgets extends AppCompatActivity {
    private ImageView button;
    SharedPreferences sharedPreferences;
    final String SAVED_ID = "ID";
    private ImageButton chat;
    private ImageButton categories;
    private ImageButton cart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main_widgets);

        button = findViewById(imageView);
        button.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Temp.class);
            startActivity(intent);
        });

        chat = findViewById(R.id.messageButton);
        chat.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Chat.class);
            startActivity(intent);
        });

        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        Integer id = sharedPreferences.getInt(SAVED_ID, 0);

        ImageButton Catalog = findViewById(R.id.menuButton);

        Catalog.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Categories.class);
            startActivity(intent);
        });

        ImageButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, CartActivity.class);
            startActivity(intent);

        });
        categories = findViewById(R.id.menuButton);
        categories.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Categories.class);
            startActivity(intent);
        });
        cart = findViewById(R.id.cartButton);
        cart.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, CartActiv.class);
            startActivity(intent);
        });
    }

}
