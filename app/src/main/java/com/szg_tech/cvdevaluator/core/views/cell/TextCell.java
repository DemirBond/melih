package com.szg_tech.cvdevaluator.core.views.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.views.CustomTextView;

public class TextCell extends LinearLayout implements CellItem {
    private CustomTextView textView;

    public TextCell(Context context) {
        super(context);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public TextCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.text_cell, this);
        initView();
    }

    private void initView() {
        textView = (CustomTextView) findViewById(R.id.text);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {

    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }

}