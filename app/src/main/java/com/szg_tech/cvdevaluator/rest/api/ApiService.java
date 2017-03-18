package com.szg_tech.cvdevaluator.rest.api;

import com.szg_tech.cvdevaluator.rest.requests.LoginRequest;
import com.szg_tech.cvdevaluator.rest.responses.EvaluationResponse;
import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    public Call<EvaluationResponse> computeEvaluation(@QueryMap(encoded = true) Map<String, Object> options);
}
