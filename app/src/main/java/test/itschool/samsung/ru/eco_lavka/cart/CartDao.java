package test.itschool.samsung.ru.eco_lavka.cart;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CartDao {
    @Query("SELECT * FROM cart")
    List<Cart> getAll();

    @Query("SELECT * FROM cart WHERE id = :id")
    Cart getById(long id);

    @Insert
    void insert(Cart cart);

    @Update
    void update(Cart cart);

    @Delete
    void delete(Cart cart);
}
