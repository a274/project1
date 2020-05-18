package test.itschool.samsung.ru.eco_lavka.server_connect;

public interface ServerConnecting {
    public default String URL() {
        String URL = "https://server-a274.herokuapp.com/";
        return URL;
    }

    public default String LOG_TAG() {
        String log = "MainActivity";
        return log;
    }
}
