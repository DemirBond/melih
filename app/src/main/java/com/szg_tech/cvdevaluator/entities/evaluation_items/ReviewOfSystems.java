package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class ReviewOfSystems extends SectionEvaluationItem {
    ReviewOfSystems(Context context) {
        super(context, ConfigurationParams.REVIEW_OF_SYSTEMS, null, false);
        name = context.getString(R.string.review_of_systems);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {{
            add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_CHANGE, context.getString(R.string.weight_change), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.THYROTOXICOSIS, context.getString(R.string.thyrotoxicosis), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PALPITATIONS, context.getString(R.string.palpitations), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.OSA_SYMPTOMS, context.getString(R.string.osa_symptoms), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.PREVIOUS_DVT_PE, context.getString(R.string.previous_dvt_pe), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.ACTIVE_PEPTIC_ULCER_DISEASE, context.getString(R.string.active_peptic_ulcer_disease), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.LIVER_DISEASE, context.getString(R.string.liver_disease), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.TIA, context.getString(R.string.tia), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.BLEED_IN_THE_PAST_3_MONTHS, context.getString(R.string.bleed_in_the_past_3_months), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.ORTHOPNEA, context.getString(R.string.orthopnea), false));
            add(new BooleanEvaluationItem(context, ConfigurationParams.LEGSWELLING, context.getString(R.string.leg_swelling), false));
        }};
    }
}
