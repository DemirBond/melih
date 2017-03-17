package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

import java.util.ArrayList;

public class HeartPartnerEvaluationItem extends EvaluationItem {
    private String hospitalName;
    private String departmentName;
    private String description;
    private String hours;
    private ArrayList<EvaluationItem> evaluationItems;

    public HeartPartnerEvaluationItem(Context context, String id,
                                      String hospitalName, String departmentName, String description, String hours,
                                      ArrayList<EvaluationItem> evaluationItems) {
        super(context, id, null, null, false);
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.description = description;
        this.hours = hours;
        this.evaluationItems = evaluationItems;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }

    public String getHours() {
        return hours;
    }

    public ArrayList<EvaluationItem> getEvaluationItems() {
        return evaluationItems;
    }
}
