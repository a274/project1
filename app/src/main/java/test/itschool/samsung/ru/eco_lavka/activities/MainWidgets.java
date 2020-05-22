package test.itschool.samsung.ru.eco_lavka.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import test.itschool.samsung.ru.eco_lavka.R;
<<<<<<< HEAD
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.AppDatabase;
import test.itschool.samsung.ru.eco_lavka.cart.CartActivity;
import test.itschool.samsung.ru.eco_lavka.cart.CartDao;
=======
import test.itschool.samsung.ru.eco_lavka.cart.AddProduct;
import test.itschool.samsung.ru.eco_lavka.cart.GetCart;

import static test.itschool.samsung.ru.eco_lavka.R.id.imageView;
import static test.itschool.samsung.ru.eco_lavka.R.layout.main_widgets;

>>>>>>> master

public class MainWidgets extends AppCompatActivity {
    private ImageView buttton;
    SharedPreferences sharedPreferences;
    final String SAVED_ID = "ID";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main_widgets);

        buttton = findViewById(imageView);
        buttton.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Temp.class);
            startActivity(intent);
        });



        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        Integer id = sharedPreferences.getInt(SAVED_ID, 0);


        ImageButton Catalog = findViewById(R.id.menuButton);

        Catalog.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Categories.class);
            startActivity(intent);
<<<<<<< HEAD
        });

        ImageButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, CartActivity.class);
            startActivity(intent);
=======
>>>>>>> master
        });
    }

}
