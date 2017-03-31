package com.szg_tech.cvdevaluator.fragments.register;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.fragments.login.LoginFragment;

/**
 * Created by ahmetkucuk on 3/25/17.
 */

public class RegisterPresenterImpl extends AbstractPresenter<RegisterView> implements RegisterPresenter {


    RegisterPresenterImpl(RegisterView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new RegisterPresenterImpl.RecyclerViewAdapter(activity));
        }
    }

    @Override
    public void onResume() {

        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.register);
                actionBar.setDisplayHomeAsUpEnabled(false);
                int actionBarColor = ContextCompat.getColor(activity, R.color.colorPrimary);
                actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
            }
        }

    }


    class RecyclerViewAdapter extends RecyclerView.Adapter<RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder> {
        private LayoutInflater layoutInflater;

        RecyclerViewAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.register_layout, parent, false);
            return new RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RegisterPresenterImpl.RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.registerButton.setOnClickListener(v -> {
                        System.out.println("I am in SignupFragment on click");
                    }
            );

            holder.linkLogin.setOnClickListener(v -> {
                getSupportFragmentManager().popBackStack();
            });
        }


        @Override
        public int getItemCount() {
            return 1;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            View view;
            TextView name;
            TextView email;
            TextView password;
            TextView registerButton;
            TextView linkLogin;

            ViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                name = (TextView) itemView.findViewById(R.id.input_name);
                email = (TextView) itemView.findViewById(R.id.input_email);
                password = (TextView) itemView.findViewById(R.id.input_password);
                password = (TextView) itemView.findViewById(R.id.input_re_enter_password);
                linkLogin = (TextView) itemView.findViewById(R.id.link_login);
                registerButton = (TextView) itemView.findViewById(R.id.btn_register);
            }
        }
    }

}
