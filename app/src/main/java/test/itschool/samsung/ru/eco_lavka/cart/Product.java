package test.itschool.samsung.ru.eco_lavka.cart;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public long productId;

    public double productAmount;
}
