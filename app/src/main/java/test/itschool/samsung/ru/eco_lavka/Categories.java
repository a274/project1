package test.itschool.samsung.ru.eco_lavka;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Categories extends Activity {
    final  String[] categories = new String[] {"Молоко", "Мясо", "Овощи"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_categories);
<<<<<<< HEAD:app/src/main/java/test/itschool/samsung/ru/eco_lavka/activities/Categories.java
        RecyclerView mRecyclerView = findViewById(R.id.recycler_categories);
=======
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_categories);
>>>>>>> develop:app/src/main/java/test/itschool/samsung/ru/eco_lavka/Categories.java

        mRecyclerView.setHasFixedSize(true);

// use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

// specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new AdapterMenu(categories);
        mRecyclerView.setAdapter(mAdapter);
    }

}

