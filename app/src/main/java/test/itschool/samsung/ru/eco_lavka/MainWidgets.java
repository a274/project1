package test.itschool.samsung.ru.eco_lavka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD:app/src/main/java/test/itschool/samsung/ru/eco_lavka/activities/MainWidgets.java

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.AppDatabase;
import test.itschool.samsung.ru.eco_lavka.cart.CartActivity;
import test.itschool.samsung.ru.eco_lavka.cart.AddProduct;
import test.itschool.samsung.ru.eco_lavka.cart.GetCart;

import static test.itschool.samsung.ru.eco_lavka.R.id.imageView;
import static test.itschool.samsung.ru.eco_lavka.R.layout.main_widgets;
=======
>>>>>>> develop:app/src/main/java/test/itschool/samsung/ru/eco_lavka/MainWidgets.java

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

<<<<<<< HEAD:app/src/main/java/test/itschool/samsung/ru/eco_lavka/activities/MainWidgets.java


        sharedPreferences = getSharedPreferences("user_setting", MODE_PRIVATE);
        Integer id = sharedPreferences.getInt(SAVED_ID, 0);


        ImageButton Catalog = findViewById(R.id.menuButton);
=======
        ImageButton Catalog = (ImageButton) findViewById(R.id.menuButton);
>>>>>>> develop:app/src/main/java/test/itschool/samsung/ru/eco_lavka/MainWidgets.java

        Catalog.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Categories.class);
            startActivity(intent);
        });

<<<<<<< HEAD:app/src/main/java/test/itschool/samsung/ru/eco_lavka/activities/MainWidgets.java
        ImageButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, CartActivity.class);
            startActivity(intent);

        });
    }

=======
>>>>>>> develop:app/src/main/java/test/itschool/samsung/ru/eco_lavka/MainWidgets.java
}
