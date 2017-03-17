package com.szg_tech.cvdevaluator.rest;

import com.szg_tech.cvdevaluator.rest.requests.LoginRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public interface ApiService {

//    @GET("/api/api/values")
//    public void computeEvaluation(Callback<EvaluationResponse> callback);


    @GET("/api/api/values")
    public Call<String> computeEvaluation();

    @GET("/api/api/values")
    public Call<String> computeEvaluation(@QueryMap Map<String, Object> options);
}
