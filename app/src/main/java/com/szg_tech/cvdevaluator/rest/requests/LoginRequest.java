package com.szg_tech.cvdevaluator.rest.requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginRequest {

    @SerializedName("grant_type")
    public String grant_type;
    public String username;
    public String password;

    public LoginRequest(String grant_type, String username, String password) {
        this.grant_type = grant_type;
        this.username = username;
        this.password = password;
    }
}
