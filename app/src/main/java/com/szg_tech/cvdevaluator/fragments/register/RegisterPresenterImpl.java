package com.szg_tech.cvdevaluator.fragments.register;

import android.app.Activity;

import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.core.Presenter;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class RegisterPresenterImpl extends AbstractPresenter<RegisterView> implements RegisterView {


    public RegisterPresenterImpl(RegisterView view) {
        super(view);
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public Presenter createPresenter() {
        return null;
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {

    }
}
