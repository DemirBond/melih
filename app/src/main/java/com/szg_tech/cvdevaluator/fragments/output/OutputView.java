package com.szg_tech.cvdevaluator.fragments.output;

import android.support.v7.widget.RecyclerView;

import com.szg_tech.cvdevaluator.core.MVPView;

interface OutputView extends MVPView {
    RecyclerView getRecyclerView();
}
