package com.szg_tech.cvdevaluator.rest.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginResponse {

    @SerializedName("access_token")
    public String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
