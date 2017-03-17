package com.szg_tech.cvdevaluator.activities.main;

import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.core.ConfigurableFragment;
import com.szg_tech.cvdevaluator.fragments.about.AboutFragment;
import com.szg_tech.cvdevaluator.fragments.home.HomeFragment;

class MainActivityPresenterImpl extends AbstractPresenter<MainActivityView> implements MainActivityPresenter {
    MainActivityPresenterImpl(MainActivityView view) {
        super(view);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConfigurableFragment fragment = null;
        String backStackName = null;
        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                backStackName = HomeFragment.class.getSimpleName();
                break;
            case R.id.about:
                fragment = new AboutFragment();
                backStackName = AboutFragment.class.getSimpleName();
                break;
            case R.id.sign:
                boolean isAuthorized = item.getTitle().toString().equals(getActivity().getResources().getString(R.string.sign_in_up));
                if (isAuthorized) {
                    item.setTitle(getActivity().getResources().getString(R.string.sign_out));
                } else {
                    item.setTitle(getActivity().getResources().getString(R.string.sign_in_up));
                }
                OnAuthorizationChangedListener onAuthorizationChangedListener = getView().getOnAuthorizationChangedListener();
                if (onAuthorizationChangedListener != null) {
                    onAuthorizationChangedListener.onAuthorizationChanged(isAuthorized);
                }
                return true;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null && fragment != null) {
            int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
            if (backStackEntryCount < 1 || !fragment.getClass().getSimpleName().equals(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName())) {
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(backStackName).commit();
                return true;
            }
        }
        return false;
    }
}
