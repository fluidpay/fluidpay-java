import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.models.customers.*;
import com.fluidpay.sdk.models.transactions.Address;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {
    private Connection c = new Connection();

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    private CreateCustomerRequest creCusReq = new CreateCustomerRequest(
            "test description",
            new CustomerPaymentMethodRequest(
                    new CustomerPaymentRequest(
                            "4111111111111111",
                            "12/20"
                    )
            ),
            new Address(
                    "John",
                    "Smith",
                    "Some Business",
                    "123 Some St",
                    "STE 1",
                    "Some Town",
                    "IL",
                    "60185",
                    "US",
                    "55555555",
                    "5555555555",
                    "user@somesite.com"
            ),
            new Address(
                    "John",
                    "Smith",
                    "Some Business",
                    "123 Some St",
                    "STE 1",
                    "Some Town",
                    "IL",
                    "60185",
                    "US",
                    "55555555",
                    "5555555555",
                    "user@somesite.com"
            )
    );
    private CustomerAddressRequest creCusAdrReq = new CustomerAddressRequest(
            "John",
            "Smith",
            "Some Business",
            "123 Some St",
            "STE 1",
            "Some Town",
            "IL",
            "60185",
            "US",
            "55555555",
            "5555555555",
            "user@somesite.com"
    );
    private CustomerAddressRequest updCusAdrReq = new CustomerAddressRequest(
            "Jane",
            "Taylor",
            "Some Business",
            "123 Some St",
            "STE 1",
            "Some Town",
            "IL",
            "60185",
            "US",
            "55555555",
            "5555555555",
            "user@somesite.com"
    );

    private CustomerPaymentRequest creCusPayReq = new CustomerPaymentRequest(
            "4111111111111111",
            "12/20"
    );
    private CustomerPaymentRequest updCusPayReq = new CustomerPaymentRequest(
            "4111111111111555",
            "12/21"
    );

    @Test
    void testCustomer() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        CustomerResponse creCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMER, id, false, true);
            creCusRes = fp.createCustomer(creCusReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creCusRes.getMsg());

        String cusId = creCusRes.getData().getId();
        id.put("customerId", cusId);

        CustomerResponse getCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
            getCusRes = fp.getCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getCusRes.getMsg());

        // Address token section

        CustomerAddressResponse creCusAdrRes = new CustomerAddressResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESS, id, false, true);
            creCusAdrRes = fp.createCustomerAddress(creCusAdrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creCusAdrRes.getMsg());

        String adrId = creCusAdrRes.getData().getId();
        id.put("addressTokenId", adrId);

        CustomerAddressesResponse getCusAdrsRes = new CustomerAddressesResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESSES, id, false, true);
            getCusAdrsRes = fp.getCustomerAddresses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getCusAdrsRes.getMsg());
        assertNotEquals(0, getCusAdrsRes.getTotalCount());

        CustomerAddressesResponse getCusAdrRes = new CustomerAddressesResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id, false, true);
            getCusAdrRes = fp.getCustomerAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getCusAdrRes.getMsg());

        CustomerAddressResponse updCusAdrRes = new CustomerAddressResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id, false, true);
            updCusAdrRes = fp.updateCustomerAddress(updCusAdrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updCusAdrRes.getMsg());

        // Payment token section

        CustomerPaymentResponse creCusPayRes = new CustomerPaymentResponse();
        id.put("paymentType", "card");
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENT, id, false, true);
            creCusPayRes = fp.createCustomerPayment(creCusPayReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creCusPayRes.getMsg());

        String payId = creCusPayRes.getData().getCard().getId();
        id.put("paymentTokenId", payId);

        CustomerPaymentsResponse getCusPaysRes = new CustomerPaymentsResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENT, id, false, true);
            getCusPaysRes = fp.getCustomerPayments();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getCusPaysRes.getMsg());
        assertNotEquals(0, getCusPaysRes.getTotalCount());

        CustomerPaymentsResponse getCusPayRes = new CustomerPaymentsResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id, false, true);
            getCusPayRes = fp.getCustomerPayment();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getCusPayRes.getMsg());

        /*
        CustomerPaymentResponse updCusPayRes = new CustomerPaymentResponse;
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id, false, true);
            updCusPayRes = fp.updateCustomerPayment(updCusPayReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updCusPayRes.getMsg());
        */

        // customer update

        UpdateCustomerRequest updCusReq = new UpdateCustomerRequest(
                "test update description",
                "card",
                payId,
                adrId,
                adrId
        );

        CustomerResponse updCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
            updCusRes = fp.updateCustomer(updCusReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updCusRes.getMsg());

        /*
        CustomerAddressResponse delCusAdrRes = new CustomerAddressResponse;
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id, false, true);
            delCusAdrRes = fp.deleteCustomerAddress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delCusAdrRes.getMsg());

        CustomerPaymentResponse delCusPayRes = new CustomerPaymentResponse;
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id, false, true);
            delCusPayRes = fp.deleteCustomerPayment();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delCusPayRes.getMsg());
        */

        CustomerResponse delCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
            delCusRes = fp.deleteCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delCusRes.getMsg());
    }
}