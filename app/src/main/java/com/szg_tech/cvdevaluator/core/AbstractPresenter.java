package com.szg_tech.cvdevaluator.core;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class AbstractPresenter<T extends MVPView> implements Presenter {

    private final T view;

    public AbstractPresenter(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    protected Activity getActivity() {
        return getView().getActivity();
    }

    protected FragmentManager getSupportFragmentManager() {
        FragmentManager fragmentManager = null;
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            fragmentManager = activity.getSupportFragmentManager();
        }
        return fragmentManager;
    }

    public void popBackStack() {
        popBackStack(1);
    }

    protected void popBackStack(int count) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            try {
                for (int i = 0; i < count; i++) {
                    fragmentManager.popBackStack();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    protected void runOnUiThread(Runnable action) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(action);
        }
    }
}
