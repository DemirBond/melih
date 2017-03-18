package com.szg_tech.cvdevaluator.rest.requests;

import com.szg_tech.cvdevaluator.entities.evaluation_items.Evaluation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmetkucuk on 3/18/17.
 */

public class EvaluationRequest {

    private int age;
    private int gender;
    private int SBP;
    private int DBP;
    private boolean isPAH;
    private String inputs;


    public EvaluationRequest(int age, int gender, int SBP, int DBP, boolean isPAH, String inputs) {
        this.age = age;
        this.gender = gender;
        this.SBP = SBP;
        this.DBP = DBP;
        this.isPAH = isPAH;
        this.inputs = inputs;
    }

    public static EvaluationRequest mock() {
        return new EvaluationRequest(25, 1, 125, 55, false, "abc|def");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("gender", gender);
        map.put("SBP", SBP);
        map.put("DBP", DBP);
        map.put("isPAH", isPAH);
        map.put("inputs", inputs);
        return map;
    }
}
