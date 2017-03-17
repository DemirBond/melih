package com.szg_tech.cvdevaluator.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginClient {

    private static final String BASE_URL = "http://www.cvdevaluator.com/";
    private LoginService loginService;

    public LoginClient() {
        Gson gson = new GsonBuilder()
                .create();


        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();


        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        loginService = restAdapter.create(LoginService.class);
    }

    public LoginService getLoginService() {
        return loginService;
    }
}
