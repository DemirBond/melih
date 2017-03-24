package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class NonCardiacSurgicalRisk extends SectionEvaluationItem {
    NonCardiacSurgicalRisk(Context context) {
        super(context, ConfigurationParams.NONCARDIAC_SURGICAL_RISK, null, false);
        name = context.getString(R.string.noncardiac_surgical_risk);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.CURRENT_THERAPIES;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(context, ConfigurationParams.EMERGENCY_SURGERY, context.getString(R.string.emergency_surgery), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.INTERMEDIATE_RISK, context.getString(R.string.intermediate_risk), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.HIGH_RISK, context.getString(R.string.high_risk), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.LOW_RISK_SURGERY_CATARACT_PLASTIC, context.getString(R.string.low_risk_surgery_cataract_plastic), false));
                add(new BooleanEvaluationItem(context, ConfigurationParams.UNABLE_TO_EXERCISE_PHYSICALLY_INACTIVE, context.getString(R.string.unable_to_exercise_physically_inactive), false));
                add(new NumericalEvaluationItem(context, ConfigurationParams.METS, context.getString(R.string.mets), context.getString(R.string.value), 0, 21, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.DUKE_ACTIVITY_SCORE_INDEX, context.getString(R.string.duke_activity_score_index), context.getString(R.string.value), 0, 99, false, true));
            }
        };
    }
}
