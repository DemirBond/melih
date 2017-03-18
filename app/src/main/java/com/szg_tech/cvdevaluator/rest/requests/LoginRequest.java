package com.szg_tech.cvdevaluator.rest.requests;

import com.google.gson.annotations.SerializedName;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class LoginRequest {

    @SerializedName("grantType")
    public String grantType;
    public String username;
    public String password;

    public LoginRequest(String grantType, String username, String password) {
        this.grantType = grantType;
        this.username = username;
        this.password = password;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("grant_type=");
        builder.append(grantType);
        builder.append("&username=");
        builder.append(username);
        builder.append("&password=");
        builder.append(password);
        return builder.toString();
    }
}
