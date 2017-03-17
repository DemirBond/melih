package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

public class StringEvaluationItem extends EvaluationItem {
    private String text;
    private String validationRegexp;

    public StringEvaluationItem(Context context, String id, String name, String hint, boolean isMandatory, String validationRegexp) {
        super(context, id, name, hint, isMandatory);
        this.validationRegexp = validationRegexp;
        if (!isMandatory) {
            setValid(true);
        } else {
            setValid(false);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (text != null) {
            setValid(true);
        } else {
            if (!isMandatory()) {
                setValid(true);
            } else {
                setValid(false);
            }
        }
    }

    public String getValidationRegexp() {
        return validationRegexp;
    }

    @Override
    public Object getValue() {
        return text;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof String) {
            setText((String) value);
        }
    }
}
