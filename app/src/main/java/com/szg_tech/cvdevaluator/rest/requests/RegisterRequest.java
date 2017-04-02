package com.szg_tech.cvdevaluator.rest.requests;

/**
 * Created by ahmetkucuk on 4/2/17.
 */

public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;


    public RegisterRequest(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getPlainBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("name=");
        builder.append(name);
        builder.append("&email=");
        builder.append(email);
        builder.append("&password=");
        builder.append(password);
        builder.append("&ConfirmPassword=");
        builder.append(confirmPassword);
        return builder.toString();
    }

}
