package com.szg_tech.cvdevaluator.fragments.output;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.AbstractPresenter;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.core.OutputRecyclerViewAdapter;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.HeartPartnerEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.ICOCellEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.TextEvaluationItem;
import com.szg_tech.cvdevaluator.rest.api.RestClientProvider;
import com.szg_tech.cvdevaluator.rest.requests.EvaluationRequest;
import com.szg_tech.cvdevaluator.rest.responses.EvaluationResponse;
import com.szg_tech.cvdevaluator.rest.responses.Field;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class OutputPresenterImpl extends AbstractPresenter<OutputView> implements OutputPresenter {
    private int status;

    OutputPresenterImpl(OutputView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        status = new Random().nextInt(3);
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            computeAndShowEvaluations(activity, recyclerView);
        }
    }

    public void computeAndShowEvaluations(Activity activity, RecyclerView recyclerView) {

        RestClientProvider.get().getApi().computeEvaluation(EvaluationRequest.mock().toMap()).enqueue(new Callback<EvaluationResponse>() {
            @Override
            public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                ArrayList evaluationItems = new ArrayList<EvaluationItem>();
                evaluationItems.add(new BoldEvaluationItem(activity, ConfigurationParams.OVERVIEW, activity.getString(R.string.overview), false));
                for(Field f: response.body().getOutputs()) {
                    evaluationItems.add(new TextEvaluationItem(activity, f.getPar(), f.getListView(), false));
                }
                recyclerView.setAdapter(new OutputRecyclerViewAdapter(activity, getSampleEvaluationList(activity)));
            }

            @Override
            public void onFailure(Call<EvaluationResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onReturnToEvaluationButtonClick() {
        popBackStack();
    }

    @Override
    public void onCompleteEvaluationButtonClick() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(R.string.output);
            }
            setActionBarColorDependingOnOutputStatus((AppCompatActivity) activity);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                popBackStack();
                break;
        }
        return true;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.home).setVisible(false);
    }

    private void setActionBarColorDependingOnOutputStatus(AppCompatActivity activity) {
        int actionBarColor;
        int statusBarColor;
        switch (status) {
            case 0: //BAD
                actionBarColor = ContextCompat.getColor(activity, R.color.salmon);
                statusBarColor = ContextCompat.getColor(activity, R.color.grapefruit);
                break;
            case 1: //MIDDLE
                actionBarColor = ContextCompat.getColor(activity, R.color.dark_cream);
                statusBarColor = ContextCompat.getColor(activity, R.color.light_gold);
                break;
            case 2: //GOOD
            default:
                actionBarColor = ContextCompat.getColor(activity, R.color.hospital_green);
                statusBarColor = ContextCompat.getColor(activity, R.color.hospital_green_status);
                break;
        }
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.setStatusBarColor(statusBarColor);
        }
    }

    public ArrayList<EvaluationItem> getSampleEvaluationList(Activity activity) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BoldEvaluationItem(activity, ConfigurationParams.OVERVIEW, activity.getString(R.string.overview), false));
                add(new TextEvaluationItem(activity, "temp", "This is a placeholder for a description of what the output/results may be. This can also be omitted altogether. The background color for the output will serve as a severity of the prognosis.", false));

                if (status != 2) {
                    add(new HeartPartnerEvaluationItem(activity, "heart_partner", "Piedmost Hospital", "Name of Department",
                            "Backed by more than a century of experience, Piedmont Heart with its team of physicians is an established leader in heart care and…",
                            "12:00 PM - 11:30 PM", new ArrayList<EvaluationItem>() {
                        {

                        }
                    }));
                }

                add(new BoldEvaluationItem(activity, ConfigurationParams.DIAGNOSTICS, activity.getString(R.string.diagnostics), false));
                add(new TextEvaluationItem(activity, "temp", "This is a placeholder for a description of what the output/results may be. This can also be omitted altogether. The background color for the output will serve as a severity of the prognosis.", false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.THERAPEUTICS, activity.getString(R.string.therapeutics), false));
                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.ICD_10, activity.getString(R.string.icd_10), false));

                if (status == 0) {
                    add(new ICOCellEvaluationItem(activity, "i50.9", "I50.9", "Heart failure, unspecified", "ICD-10", "Billable"));
                }

                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
                add(new BoldEvaluationItem(activity, ConfigurationParams.REFERENCES, activity.getString(R.string.references), false));
                add(new TextEvaluationItem(activity, ConfigurationParams.NO_INFO_AVAILABLE, activity.getString(R.string.no_info_available), false));
            }
        };
    }
}
