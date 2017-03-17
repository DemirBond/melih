package com.szg_tech.cvdevaluator.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class RestClient
{
    private static final String BASE_URL = "http://www.cvdevaluator.com/";
    private static ApiService apiService;

    static {
        setupRestClient();
    }

    private RestClient() { }

    private static void setupRestClient() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public static ApiService get() {
        return apiService;
    }
}
