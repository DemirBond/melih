package com.szg_tech.cvdevaluator.rest;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class RestClientProvider {

    private static RestClient restClient;

    public static RestClient get(String token) {
        if (restClient == null) {
            restClient = new RestClient(token);
        }
        return restClient;
    }

}
