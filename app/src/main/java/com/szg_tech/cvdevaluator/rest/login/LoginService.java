package com.szg_tech.cvdevaluator.rest.login;

import com.szg_tech.cvdevaluator.rest.requests.LoginRequest;
import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public interface LoginService {

    @POST("token")
    public Call<LoginResponse> login(@Body String loginBody);
}