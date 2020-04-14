package com.example.loginandsignupexample.config;

public class ApiUtils {
    private ApiUtils() {}

    public static APIConnect getAPIService() {
        return RetrofitClient.getClient("http://192.168.1.2:3000/").create(APIConnect.class);
    }
}
