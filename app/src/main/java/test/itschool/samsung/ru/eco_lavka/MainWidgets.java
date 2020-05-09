package test.itschool.samsung.ru.eco_lavka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainWidgets extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_widgets);

        ImageButton Catalog = (ImageButton) findViewById(R.id.menuButton);

        Catalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainWidgets.this, CategoriesMenu.class);
                startActivity(intent);
            }
        });
    }

}
