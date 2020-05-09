package test.itschool.samsung.ru.eco_lavka;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoriesMenu extends AppCompatActivity {

    private List<Categories> states = new ArrayList();

    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.list_categories);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.menu_main, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Categories selectedState = (Categories) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        states.add(new Categories ("Молочные продукты", R.drawable.milk));
        states.add(new Categories ("Мясо", R.drawable.meat));
        states.add(new Categories ("Овощи", R.drawable.vegetable));
    }
}
