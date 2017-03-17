package com.szg_tech.cvdevaluator.fragments.evaluation_list;

import android.view.MenuItem;

import com.szg_tech.cvdevaluator.core.Presenter;

interface EvaluationListPresenter extends Presenter {
    void onCreate();

    void onBottomButtonClick();

    void onResume();

    boolean onOptionsItemSelected(MenuItem item);

    void onPause();
}
