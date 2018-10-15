package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.authentication.GeneralResponse;
import com.fluidpay.sdk.models.users.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Users {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    public UserResponse changePassword(HttpURLConnection conn, ChangePasswordRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, UserResponse.class);
    }

    public UserResponse createUser(HttpURLConnection conn, CreateUserRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, UserResponse.class);
    }

    public UserResponse updateUser(HttpURLConnection conn, UpdateUserRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, UserResponse.class);
    }

    public UserResponse getUser(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, UserResponse.class);
    }

    public UserResponse currentUser(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, UserResponse.class);
    }

    public UsersResponse getUsers(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, UsersResponse.class);
    }

    public GeneralResponse deleteUser(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, GeneralResponse.class);
    }
}
