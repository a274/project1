package test.itschool.samsung.ru.eco_lavka.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import test.itschool.samsung.ru.eco_lavka.R;

public class FragmetCart extends Fragment {
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_cart, container, false);
    }
}
