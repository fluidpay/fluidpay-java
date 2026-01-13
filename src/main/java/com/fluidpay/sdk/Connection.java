package com.fluidpay.sdk;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Connection {
    private final String urlProduction = "https://api.fluidpay.com/api";
    private final String urlSandbox = "https://sandbox.fluidpay.com/api";
    private final String urlLocalDev = "http://localhost:8001/api";

    private Utils util = new Utils();

    private HttpsURLConnection conn(String[] params) throws IOException {
        String path = urlProduction + util.urlBuilder(params);
        URL url = new URL(path);
        return (HttpsURLConnection) url.openConnection();
    }

    private HttpURLConnection conn(String[] params, boolean sandbox, boolean localDev) throws IOException {
        String baseUrl;
        if (localDev) {
            String path = urlLocalDev + util.urlBuilder(params);
            URL url = new URL(path);
            return (HttpURLConnection) url.openConnection();
        } else if (sandbox) {
            baseUrl = urlSandbox;
        } else {
            baseUrl = urlProduction;
        }
        String path = baseUrl + util.urlBuilder(params);
        URL url = new URL(path);
        return (HttpsURLConnection) url.openConnection();
    }

    public HttpURLConnection init(ConnectionType connType, Map<String, String> params, boolean sandbox, boolean localDev) throws IOException {
        String[] param;
        switch (connType) {
            case CREATEKEY:
                param = new String[]{"user", "apikey"};
                return conn(param, sandbox, localDev);
            case GETKEYS:
                param = new String[]{"user", "apikeys"};
                return conn(param, sandbox, localDev);
            case DELETEKEY:
                if (params.containsKey("apiKeyId")) {
                    param = new String[]{"user", "apikey", params.get("apiKeyId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing api key id");
            case CUSTOMER:
                param = new String[]{"vault", "customer"};
                return conn(param, sandbox, localDev);
            case CUSTOMERID:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", params.get("customerId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERUPDATE:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERSEARCH:
                param = new String[]{"vault", "customer", "search"};
                return conn(param, sandbox, localDev);
            case CUSTOMERADDRESS:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERADDRESSES:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERADDRESSID:
                if (params.containsKey("customerId") && params.containsKey("addressTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address", params.get("addressTokenId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer or address token id");
            case CUSTOMERCARD:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "card"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERCARDID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "card", params.get("paymentTokenId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERACH:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "ach"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERACHID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "ach", params.get("paymentTokenId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERTOKEN:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "token"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERTOKENID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "token", params.get("paymentTokenId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERAPPLEPAY:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "applepay"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            case CUSTOMERGOOGLEPAY:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "googlepay"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id");
            // Legacy support - keep for backward compatibility but map to card
            case CUSTOMERPAYMENT:
                if (params.containsKey("customerId") && params.containsKey("paymentType")) {
                    String paymentType = params.get("paymentType");
                    if ("card".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "card"};
                    } else if ("ach".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "ach"};
                    } else {
                        throw new Error("unsupported payment type: " + paymentType);
                    }
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer id or payment type");
            case CUSTOMERPAYMENTID:
                if (params.containsKey("customerId") && params.containsKey("paymentType") && params.containsKey("paymentTokenId")) {
                    String paymentType = params.get("paymentType");
                    if ("card".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "card", params.get("paymentTokenId")};
                    } else if ("ach".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "ach", params.get("paymentTokenId")};
                    } else {
                        throw new Error("unsupported payment type: " + paymentType);
                    }
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing customer, payment token id or payment type");
            case ADDON:
                param = new String[]{"recurring", "addon"};
                return conn(param, sandbox, localDev);
            case ADDONS:
                param = new String[]{"recurring", "addons"};
                return conn(param, sandbox, localDev);
            case ADDONID:
                if (params.containsKey("addOnId")) {
                    param = new String[]{"recurring", "addon", params.get("addOnId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing add on id");
            case DISCOUNT:
                param = new String[]{"recurring", "discount"};
                return conn(param, sandbox, localDev);
            case DISCOUNTS:
                param = new String[]{"recurring", "discounts"};
                return conn(param, sandbox, localDev);
            case DISCOUNTID:
                if (params.containsKey("discountId")) {
                    param = new String[]{"recurring", "discount", params.get("discountId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing discount id");
            case PLAN:
                param = new String[]{"recurring", "plan"};
                return conn(param, sandbox, localDev);
            case PLANS:
                param = new String[]{"recurring", "plans"};
                return conn(param, sandbox, localDev);
            case PLANID:
                if (params.containsKey("planId")) {
                    param = new String[]{"recurring", "plan", params.get("planId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing plan id");
            case SUBSCRIPTION:
                param = new String[]{"recurring", "subscription"};
                return conn(param, sandbox, localDev);
            case SUBSCRIPTIONID:
                if (params.containsKey("subscriptionId")) {
                    param = new String[]{"recurring", "subscription", params.get("subscriptionId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing subscription id");
            case TERMINALS:
                param = new String[]{"terminals"};
                return conn(param, sandbox, localDev);
            case TRANSACTION:
                param = new String[]{"transaction"};
                return conn(param, sandbox, localDev);
            case TRANSACTIONSTATUS:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONQUERY:
                param = new String[]{"transaction", "search"};
                return conn(param, sandbox, localDev);
            case TRANSACTIONCAPTURE:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "capture"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONVOID:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "void"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONREFUND:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "refund"};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing transaction id");
            case CHANGEPASSWORD:
                param = new String[]{"user", "change-password"};
                return conn(param, sandbox, localDev);
            case USER:
                param = new String[]{"user"};
                return conn(param, sandbox, localDev);
            case USERS:
                param = new String[]{"users"};
                return conn(param, sandbox, localDev);
            case USERID:
                if (params.containsKey("userId")) {
                    param = new String[]{"user", params.get("userId")};
                    return conn(param, sandbox, localDev);
                }
                throw new Error("missing user id");
            default:
                throw new Error("invalid connection type");
        }
    }

    /**
     * returns a HttpsURLConnection for further configuration
     *
     * @param connType type of connection to initiate
     * @param params   map containing IDs
     */
    public HttpsURLConnection init(ConnectionType connType, Map<String, String> params) throws IOException {
        String[] param;
        switch (connType) {
            case CREATEKEY:
                param = new String[]{"user", "apikey"};
                return conn(param);
            case GETKEYS:
                param = new String[]{"user", "apikeys"};
                return conn(param);
            case DELETEKEY:
                if (params.containsKey("apiKeyId")) {
                    param = new String[]{"user", "apikey", params.get("apiKeyId")};
                    return conn(param);
                }
                throw new Error("missing api key id");
            case CUSTOMER:
                param = new String[]{"vault", "customer"};
                return conn(param);
            case CUSTOMERID:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", params.get("customerId")};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERUPDATE:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId")};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERSEARCH:
                param = new String[]{"vault", "customer", "search"};
                return conn(param);
            case CUSTOMERADDRESS:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERADDRESSES:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERADDRESSID:
                if (params.containsKey("customerId") && params.containsKey("addressTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "address", params.get("addressTokenId")};
                    return conn(param);
                }
                throw new Error("missing customer or address token id");
            case CUSTOMERCARD:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "card"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERCARDID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "card", params.get("paymentTokenId")};
                    return conn(param);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERACH:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "ach"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERACHID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "ach", params.get("paymentTokenId")};
                    return conn(param);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERTOKEN:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "token"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERTOKENID:
                if (params.containsKey("customerId") && params.containsKey("paymentTokenId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "token", params.get("paymentTokenId")};
                    return conn(param);
                }
                throw new Error("missing customer id or payment token id");
            case CUSTOMERAPPLEPAY:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "applepay"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            case CUSTOMERGOOGLEPAY:
                if (params.containsKey("customerId")) {
                    param = new String[]{"vault", "customer", params.get("customerId"), "googlepay"};
                    return conn(param);
                }
                throw new Error("missing customer id");
            // Legacy support - keep for backward compatibility but map to card
            case CUSTOMERPAYMENT:
                if (params.containsKey("customerId") && params.containsKey("paymentType")) {
                    String paymentType = params.get("paymentType");
                    if ("card".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "card"};
                    } else if ("ach".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "ach"};
                    } else {
                        throw new Error("unsupported payment type: " + paymentType);
                    }
                    return conn(param);
                }
                throw new Error("missing customer id or payment type");
            case CUSTOMERPAYMENTID:
                if (params.containsKey("customerId") && params.containsKey("paymentType") && params.containsKey("paymentTokenId")) {
                    String paymentType = params.get("paymentType");
                    if ("card".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "card", params.get("paymentTokenId")};
                    } else if ("ach".equals(paymentType)) {
                        param = new String[]{"vault", "customer", params.get("customerId"), "ach", params.get("paymentTokenId")};
                    } else {
                        throw new Error("unsupported payment type: " + paymentType);
                    }
                    return conn(param);
                }
                throw new Error("missing customer, payment token id or payment type");
            case ADDON:
                param = new String[]{"recurring", "addon"};
                return conn(param);
            case ADDONS:
                param = new String[]{"recurring", "addons"};
                return conn(param);
            case ADDONID:
                if (params.containsKey("addOnId")) {
                    param = new String[]{"recurring", "addon", params.get("addOnId")};
                    return conn(param);
                }
                throw new Error("missing add on id");
            case DISCOUNT:
                param = new String[]{"recurring", "discount"};
                return conn(param);
            case DISCOUNTS:
                param = new String[]{"recurring", "discounts"};
                return conn(param);
            case DISCOUNTID:
                if (params.containsKey("discountId")) {
                    param = new String[]{"recurring", "discount", params.get("discountId")};
                    return conn(param);
                }
                throw new Error("missing discount id");
            case PLAN:
                param = new String[]{"recurring", "plan"};
                return conn(param);
            case PLANS:
                param = new String[]{"recurring", "plans"};
                return conn(param);
            case PLANID:
                if (params.containsKey("planId")) {
                    param = new String[]{"recurring", "plan", params.get("planId")};
                    return conn(param);
                }
                throw new Error("missing plan id");
            case SUBSCRIPTION:
                param = new String[]{"recurring", "subscription"};
                return conn(param);
            case SUBSCRIPTIONID:
                if (params.containsKey("subscriptionId")) {
                    param = new String[]{"recurring", "subscription", params.get("subscriptionId")};
                    return conn(param);
                }
                throw new Error("missing subscription id");
            case TERMINALS:
                param = new String[]{"terminals"};
                return conn(param);
            case TRANSACTION:
                param = new String[]{"transaction"};
                return conn(param);
            case TRANSACTIONSTATUS:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId")};
                    return conn(param);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONQUERY:
                param = new String[]{"transaction", "search"};
                return conn(param);
            case TRANSACTIONCAPTURE:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "capture"};
                    return conn(param);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONVOID:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "void"};
                    return conn(param);
                }
                throw new Error("missing transaction id");
            case TRANSACTIONREFUND:
                if (params.containsKey("transactionId")) {
                    param = new String[]{"transaction", params.get("transactionId"), "refund"};
                    return conn(param);
                }
                throw new Error("missing transaction id");
            case CHANGEPASSWORD:
                param = new String[]{"user", "change-password"};
                return conn(param);
            case USER:
                param = new String[]{"user"};
                return conn(param);
            case USERS:
                param = new String[]{"users"};
                return conn(param);
            case USERID:
                if (params.containsKey("userId")) {
                    param = new String[]{"user", params.get("userId")};
                    return conn(param);
                }
                throw new Error("missing user id");
            default:
                throw new Error("invalid connection type");
        }
    }
}
