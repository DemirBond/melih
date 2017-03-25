package com.szg_tech.cvdevaluator.rest.authentication;

import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public interface AuthenticationService {

    @POST("token")
    public Call<LoginResponse> login(@Body String loginBody);
}
