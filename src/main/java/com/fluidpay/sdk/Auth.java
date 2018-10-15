package com.fluidpay.sdk;

/**
 * com.fluidpay.sdk.Auth stores your authentication
 * authType can be 1 for API key and 2 for JWT token
 */
public class Auth {
    private int authType;
    private String authorization;

    public Auth(int authType, String authorization) {
        this.authType = authType;
        switch (authType) {
            case 1:
                this.authorization = authorization;
                break;
            case 2:
                this.authorization = "Bearer " + authorization;
                break;
            default:
                throw new Error("invalid authType, please give 1 or 2 as a value");
        }
    }

    public void setAuth(int authType, String authorization) {
        this.authType = authType;
        switch (authType) {
            case 1:
                this.authorization = authorization;
                break;
            case 2:
                this.authorization = "Bearer " + authorization;
                break;
            default:
                throw new Error("invalid authType, please give 1 or 2 as a value");
        }
    }

    public String getAuthorization() {
        return authorization;
    }

    public int getAuthType() {
        return authType;
    }
}
