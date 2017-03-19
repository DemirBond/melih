package com.szg_tech.cvdevaluator.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.fragments.home.HomeFragment;
import com.szg_tech.cvdevaluator.rest.login.LoginClient;
import com.szg_tech.cvdevaluator.rest.api.RestClientProvider;
import com.szg_tech.cvdevaluator.rest.requests.EvaluationRequest;
import com.szg_tech.cvdevaluator.rest.requests.LoginRequest;
import com.szg_tech.cvdevaluator.rest.responses.EvaluationResponse;
import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private MainActivityPresenter presenter = createPresenter();

    private OnAuthorizationChangedListener onAuthorizationChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new HomeFragment())
                .addToBackStack(HomeFragment.class.getSimpleName())
                .commit();
        presenter.onCreate();

        Map<String, Object> query = new HashMap<>();
        query.put("isPAH", false);
        query.put("gender", 1);
        query.put("age", 25);
        query.put("SBP", 125);
        query.put("DBP", 65);
        query.put("inputs", "chkNYHA1%7CchkDOE");

        LoginRequest loginRequest = new LoginRequest("password", "demo", "demo1");
        System.out.println(loginRequest.getPlainBody());
        new LoginClient().getLoginService().login(loginRequest.getPlainBody()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {
                    RestClientProvider.init(response.body().getAccessToken());
                } else {
                    System.out.println("Not successful" + response);
                    System.out.println("Request body " + call.request().body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenterImpl(this);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }

    @Override
    public OnAuthorizationChangedListener getOnAuthorizationChangedListener() {
        return onAuthorizationChangedListener;
    }

    public void setOnAuthorizationChangedListener(OnAuthorizationChangedListener onAuthorizationChangedListener) {
        this.onAuthorizationChangedListener = onAuthorizationChangedListener;
    }
}
