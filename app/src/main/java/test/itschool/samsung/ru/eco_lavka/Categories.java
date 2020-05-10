package test.itschool.samsung.ru.eco_lavka;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Categories extends ListActivity {
    final  String[] categories = new String[] {"Молоко", "Мясо", "Овощи"};

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<String>(this, R.layout.menu_categories, categories);
        setListAdapter(mAdapter);
    }

}

