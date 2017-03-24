package com.szg_tech.cvdevaluator.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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
}
