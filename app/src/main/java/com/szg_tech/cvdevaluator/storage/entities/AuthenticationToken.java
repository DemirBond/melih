package com.szg_tech.cvdevaluator.storage.entities;

/**
 * Created by ahmetkucuk on 3/26/17.
 */

public class AuthenticationToken {

    public static final String TOKEN = "token";
    public static final String EXPIRE_DATE = "expireDate";

    private String token;
    private long expireDate;


    public AuthenticationToken(String token, long expireDate) {
        this.token = token;
        this.expireDate = expireDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(long expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isExpired() {
        if(System.currentTimeMillis() >= expireDate)
            return true;
        return false;
    }
}
