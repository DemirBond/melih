package com.szg_tech.cvdevaluator.activities.authentication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.szg_tech.cvdevaluator.core.Presenter;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class AuthenticationActivity extends AppCompatActivity implements AuthenticationActivityView {


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Presenter createPresenter() {
        return new AuthenticationActivityPresenterImpl(this);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }
}
