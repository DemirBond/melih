package com.szg_tech.cvdevaluator.rest.requests;

import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.evaluation_items.Evaluation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmetkucuk on 3/18/17.
 */

public class EvaluationRequest {

    private int age;
    private int gender = 1;
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

    public EvaluationRequest(HashMap<String, Object> evaluationValueMap) {
        setVariablesFromMap(evaluationValueMap);
    }

    private void setVariablesFromMap(HashMap<String, Object> evaluationValueMap) {

        age = getIntVal(evaluationValueMap.get(ConfigurationParams.AGE));
        if(evaluationValueMap.containsKey(ConfigurationParams.MALE)) {
            boolean isMale = (Boolean)evaluationValueMap.get(ConfigurationParams.MALE);
            gender = isMale?1:0;
        } else {
            gender = -1;
        }

        SBP = getIntVal(evaluationValueMap.get(ConfigurationParams.SBP));
        DBP = getIntVal(evaluationValueMap.get(ConfigurationParams.DBP));
        isPAH = false;

        evaluationValueMap.remove(ConfigurationParams.AGE);
        evaluationValueMap.remove(ConfigurationParams.MALE);
        evaluationValueMap.remove(ConfigurationParams.FEMALE);
        evaluationValueMap.remove(ConfigurationParams.SBP);
        evaluationValueMap.remove(ConfigurationParams.DBP);
        evaluationValueMap.remove(ConfigurationParams.GENDER);


        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String, Object> entry: evaluationValueMap.entrySet()) {
            Object value = entry.getValue();
            boolean isAdded = false;
            if(value != null) {
                if(value instanceof Boolean) {
                    if(((Boolean)value) == true) {
                        builder.append(entry.getKey());
                        isAdded = true;
                    }
                } else {
                    builder.append(entry.getKey() + "=" + entry.getValue());
                    isAdded = true;
                }
            } else {
                builder.append(entry.getKey());
            }
            if(isAdded)
                builder.append("|");
        }
        inputs = builder.toString();
    }

    private int getIntVal(Object o) {
        if(o != null && o instanceof Double) {
            return ((Double)o).intValue();
        } else {
            System.err.println("Evaluation Request - getIntVal [there is a serious problem with Data Storage]: " + o);
        }
        return -1;
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
