package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import test.itschool.samsung.ru.eco_lavka.R;

public class CartActiv extends FragmentActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_catr);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment1 f1 = new Fragment1();
        ft.add(R.id.scroll_cart, f1);
        ft.commit();

    }
}