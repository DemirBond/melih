package com.szg_tech.cvdevaluator.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.szg_tech.cvdevaluator.storage.entities.AuthenticationToken;

public class PreferenceHelper {
    private static final String TEXT_DELTA = "text_delta";

    public static void putTextDelta(Context context, float textDelta) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putFloat(TEXT_DELTA, textDelta).apply();
    }

    public static float getTextDelta(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getFloat(TEXT_DELTA, 0);
    }

    public static void putAuthenticationToken(Context context, AuthenticationToken token) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().putString(AuthenticationToken.TOKEN, token.getToken()).apply();
        sharedPreferences.edit().putLong(AuthenticationToken.EXPIRE_DATE, token.getExpireDate()).apply();
    }

    public static AuthenticationToken getToken(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = sharedPreferences.getString(AuthenticationToken.TOKEN, "");
        long expireDate = sharedPreferences.getLong(AuthenticationToken.TOKEN, 0);
        return new AuthenticationToken(token, expireDate);
    }
}
