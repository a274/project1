package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.AddProduct;

public class Temp extends AppCompatActivity {
    private Button add;
    private Button order;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_cart);

        add = findViewById(R.id.addProduct);
        order = findViewById(R.id.order);

        add.setOnClickListener(v -> {
            AddProduct addProduct = new AddProduct();
            addProduct.start();
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
