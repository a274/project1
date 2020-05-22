package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.AddProduct;
import test.itschool.samsung.ru.eco_lavka.cart.App;
import test.itschool.samsung.ru.eco_lavka.cart.GetCart;
import test.itschool.samsung.ru.eco_lavka.cart.Product;
import test.itschool.samsung.ru.eco_lavka.cart.ProductDao;
import test.itschool.samsung.ru.eco_lavka.server_connect.Order;

public class Temp extends AppCompatActivity {
    private Button add;
    private Button order;
    //private Button delete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_cart);

        add = findViewById(R.id.addProduct);
        order = findViewById(R.id.order);
        //delete = findViewById();

        add.setOnClickListener(v -> {
            synchronized (this) {
                GetCart cart = new GetCart();
                AddProduct addProduct = new AddProduct();
                addProduct.start();
                cart.start();
            }
        });


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (this) {
                    GetCart cart = new GetCart();
                    cart.start();
                    Order order = new Order(1, cart.getProducts());
                    order.start();

                }
            }
        });
    }
}
