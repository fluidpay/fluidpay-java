package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.authentication.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Authentication {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    public JWTTokenResponse obtainJWT(HttpURLConnection conn, JWTTokenRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, JWTTokenResponse.class);
    }

    public GeneralResponse forgottenUsername(HttpURLConnection conn, ForgottenUsernameRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, GeneralResponse.class);
    }

    public GeneralResponse forgottenPassword(HttpURLConnection conn, ForgottenPasswordRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, GeneralResponse.class);
    }

    public GeneralResponse passwordReset(HttpURLConnection conn, PasswordResetRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, GeneralResponse.class);
    }

    public void tokenLogout(HttpURLConnection conn, String apiKey) throws IOException {
        util.doRequest(conn, "GET", null, apiKey);
    }
}
