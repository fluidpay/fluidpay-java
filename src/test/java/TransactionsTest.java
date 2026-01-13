import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.TestConstants;
import com.fluidpay.sdk.models.customers.*;
import com.fluidpay.sdk.models.terminals.TerminalsResponse;
import com.fluidpay.sdk.models.transactions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {
    private Connection c = new Connection();

    private Address adr = new Address(
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

    CardTransactionRequest cardTransReq = new CardTransactionRequest(
            "authorize",
            1112,
            true,
            100,
            100,
            "USD",
            "test transaction",
            "someOrderID",
            "somePONumber",
            "4.2.2.2",
            true,
            "user@home.com",
            new CardPayment(
                    new CardRequest("keyed",
                            "4012000098765439",
                            "12/20",
                            "999",
                            new CardholderAuthentication(
                                    "",
                                    "",
                                    "",
                                    ""
                            )
                    )
            ),
            adr,
            adr
    );


    @Test
    void testTransaction() {
        TransactionQueryRequest queTransReq = new TransactionQueryRequest();
        queTransReq.setTransactionId(
                new StringQuery(
                        "!=",
                        "b84vgb2j8m0jujadi4v0"
                )
        );
        queTransReq.setAmount(
                new IntQuery(
                        "<",
                        1
                )
        );

        Fluidpay fp = new Fluidpay(TestConstants.TEST_API_KEY);
        HashMap<String, String> id = new HashMap<>();

        /*
        TerminalResponse cardTransRes = new TerminalResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTION, id, false, true);
            cardTransRes = fp.doTransaction(cardTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", cardTransRes.getMsg());
        */

        CreateCustomerRequest creCusReq = new CreateCustomerRequest(
                "test description",
                new CustomerPaymentMethodRequest(
                        new CustomerPaymentRequest(
                                "4111111111111111",
                                "12/20"
                        )
                ),
                adr,
                adr
        );

        CustomerResponse creCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMER, id, false, true);
            creCusRes = fp.createCustomer(creCusReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cusId = creCusRes.getData().getId();
        id.put("customerId", cusId);

        CustomerAddressRequest creCusAdrReq = new CustomerAddressRequest(
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

        CustomerAddressResponse creCusAdrRes = new CustomerAddressResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERADDRESS, id, false, true);
            creCusAdrRes = fp.createCustomerAddress(creCusAdrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String adrId = creCusAdrRes.getData().getId();
        id.put("customerAddressId", adrId);

        CustomerPaymentRequest creCusPayReq = new CustomerPaymentRequest(
                "4111111111111111",
                "12/20"
        );

        CustomerPaymentResponse creCusPayRes = new CustomerPaymentResponse();
        id.put("paymentType", "card");
        try {
            fp.connection = c.init(ConnectionType.CUSTOMERPAYMENT, id, false, true);
            creCusPayRes = fp.createCustomerPayment(creCusPayReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String payId = creCusPayRes.getData().getCard().getId();
        id.put("customerPaymentId", payId);

        CustomerTransactionRequest custTransReq = new CustomerTransactionRequest(
                "authorize",
                1112,
                true,
                100,
                100,
                "USD",
                "test transaction",
                "someOrderID",
                "somePONumber",
                "4.2.2.2",
                true,
                "user@home.com",
                new CustomerPayment(
                        new CustomerRequest(
                                cusId,
                                "card",
                                payId,
                                adrId,
                                adrId
                        )
                ),
                adr,
                adr
        );

        TerminalResponse custTransRes = new TerminalResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTION, id, false, true);
            custTransRes = fp.doTransaction(custTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", custTransRes.getMsg());



        TerminalsResponse getTerRes = new TerminalsResponse();
        try {
            fp.connection = c.init(ConnectionType.TERMINALS, id, false, true);
            getTerRes = fp.getTerminals();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String termId = getTerRes.getData()[0].getId();
        id.put("terminalId", termId);

        TerminalTransactionRequest termTransReq = new TerminalTransactionRequest(
                "sale",
                1112,
                true,
                100,
                100,
                "USD",
                "test transaction",
                "someOrderID",
                "somePONumber",
                "4.2.2.2",
                true,
                "user@home.com",
                new TerminalPayment(
                        new TerminalRequest(
                                termId,
                                "12/20",
                                "999",
                                "both",
                                true
                        )
                ),
                adr,
                adr
        );

        TerminalResponse termTransRes = new TerminalResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTION, id, false, true);
            termTransRes = fp.doTransaction(termTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", termTransRes.getMsg());


/*
        TransactionSearchResponse queTransRes = new TransactionSearchResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTIONQUERY, id, false, true);
            queTransRes = fp.queryTransactions(queTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", queTransRes.getMsg());
*/

        id.put("transactionId", termTransRes.getData().getId());

        TransactionResponse voidTransRes = new TransactionResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTIONVOID, id, false, true);
            voidTransRes = fp.voidTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", voidTransRes.getMsg());

        TransactionCaptureRequest capTransReq = new TransactionCaptureRequest(
                custTransRes.getData().getAmount(),
                custTransRes.getData().getTaxAmount(),
                custTransRes.getData().isTaxExempt(),
                custTransRes.getData().getShippingAmount(),
                custTransRes.getData().getOrderId(),
                custTransRes.getData().getPoNumber(),
                custTransRes.getData().getIpAddress()
        );

        id.replace("transactionId", custTransRes.getData().getId());

        TransactionSearchResponse statTransRes = new TransactionSearchResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTIONSTATUS, id, false, true);
            statTransRes = fp.getTransactionStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", statTransRes.getMsg());

        TransactionResponse capTransRes = new TransactionResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTIONCAPTURE, id, false, true);
            capTransRes = fp.captureTransaction(capTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", capTransRes.getMsg());

        /*
        // Refund transaction test (commented out)
        TransactionRefundRequest refTransReq = new TransactionRefundRequest(
                termTransRes.getData().getAmount()
        );

        TransactionResponse refTransRes = new TransactionResponse();
        try {
            fp.connection = c.init(ConnectionType.TRANSACTIONREFUND, id, false, true);
            refTransRes = fp.refundTransaction(refTransReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", refTransRes.getMsg());
        */
    }

}