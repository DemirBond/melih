package com.szg_tech.cvdevaluator.rest.responses;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by ahmetkucuk on 3/16/17.
 */

public class EvaluationResponse {

    @SerializedName("stat")
    private String status;

    @SerializedName("msg")
    private String message;

    private Field[] outputs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Field[] getOutputs() {
        return outputs;
    }

    public void setOutputs(Field[] outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        return "EvaluationResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", outputs=" + Arrays.toString(outputs) +
                '}';
    }
}