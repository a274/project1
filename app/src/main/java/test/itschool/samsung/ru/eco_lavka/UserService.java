package test.itschool.samsung.ru.eco_lavka;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("login.php")
    Call<Integer> login(@Query("login") String login, @Query("password") String password);
}