package test.itschool.samsung.ru.eco_lavka.cart;

import android.app.Application;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.itschool.samsung.ru.eco_lavka.server_connect.UserService;

public class App extends Application {

    public static App instance;
    private static String URL = "https://server-a274.herokuapp.com/";
    private AppDatabase database;

    private UserService userService;
    private Gson gson;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        userService = retrofit.create(UserService.class);
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public Gson getGson() {
        return gson;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public UserService getUserService() {
        return userService;
    }
}
