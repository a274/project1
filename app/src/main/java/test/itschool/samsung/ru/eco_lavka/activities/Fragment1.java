package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import test.itschool.samsung.ru.eco_lavka.R;
import test.itschool.samsung.ru.eco_lavka.cart.AddProduct;
import test.itschool.samsung.ru.eco_lavka.cart.GetCart;
import test.itschool.samsung.ru.eco_lavka.cart.Product;
import test.itschool.samsung.ru.eco_lavka.cart.ProductActivity;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_product, container, false);
    }
}
