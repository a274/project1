package test.itschool.samsung.ru.eco_lavka;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Categories extends Activity {
    final  String[] categories = new String[] {"Молоко", "Мясо", "Овощи"};

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_categories);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_categories);

        mRecyclerView.setHasFixedSize(true);

// use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

// specify an adapter (see also next example)
        mAdapter = new AdapterMenu(categories);
        mRecyclerView.setAdapter(mAdapter);
    }

}

