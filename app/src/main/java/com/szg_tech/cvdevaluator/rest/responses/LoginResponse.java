package com.szg_tech.cvdevaluator.rest.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginResponse {

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("error")
    public String error;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSucceed() {
        if ((error == null || error.isEmpty()) && (accessToken != null || !accessToken.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
