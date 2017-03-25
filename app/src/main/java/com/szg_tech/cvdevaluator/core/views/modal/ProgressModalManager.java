package com.szg_tech.cvdevaluator.core.views.modal;

import android.app.Activity;
import android.app.ProgressDialog;

import com.szg_tech.cvdevaluator.R;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class ProgressModalManager {

    public static ProgressDialog createAndShowLoginProgressDialog(Activity activity) {
        final ProgressDialog progressDialog = new ProgressDialog(activity,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(activity.getResources().getString(R.string.authenticating));
        progressDialog.show();
        return progressDialog;
    }

    public static ProgressDialog createAndShowRegisterProgressDialog(Activity activity) {
        final ProgressDialog progressDialog = new ProgressDialog(activity,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(activity.getResources().getString(R.string.registering));
        progressDialog.show();
        return progressDialog;
    }
}
