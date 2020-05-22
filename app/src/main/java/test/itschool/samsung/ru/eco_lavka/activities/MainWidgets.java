package test.itschool.samsung.ru.eco_lavka.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.AppDatabase;
import test.itschool.samsung.ru.eco_lavka.cart.Base;
import test.itschool.samsung.ru.eco_lavka.cart.CartDao;

public class MainWidgets extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_widgets);

        // CART CREATING
        AppDatabase db = App.getInstance().getDatabase();
        CartDao cartDao = db.CartDao();

        // BUTTON ADD PRODUCT
        /*
        AddProduct addProduct = new AddProduct(cartDao);
        addProduct.run();
        */

        ImageButton Catalog = findViewById(R.id.menuButton);

        Catalog.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Categories.class);
            startActivity(intent);
        });
        ImageButton cartButton = findViewById(R.id.cartButton);

        cartButton.setOnClickListener(v -> {
            Intent intent=new Intent(MainWidgets.this, Base.class);
            startActivity(intent);
        });
    }


}
