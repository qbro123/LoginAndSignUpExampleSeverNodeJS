package com.example.loginandsignupexample.config;

import androidx.annotation.NonNull;

import com.example.loginandsignupexample.models.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIConnect {

    @NonNull
    @POST("/api/account/login")
    @FormUrlEncoded
    Call<Account> getToken(@Field("username") @NonNull String username, @Field("password") @NonNull String password);

    @NonNull
    @POST("/api/account/register")
    @FormUrlEncoded
    Call<Account> createAccount(@Field("fullname") @NonNull String fullname, @Field("username") @NonNull String username, @Field("password") @NonNull String password);

}
