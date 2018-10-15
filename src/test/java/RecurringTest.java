import com.fluidpay.sdk.*;
import com.fluidpay.sdk.models.customers.CreateCustomerRequest;
import com.fluidpay.sdk.models.customers.CustomerPaymentMethodRequest;
import com.fluidpay.sdk.models.customers.CustomerPaymentRequest;
import com.fluidpay.sdk.models.customers.CustomerResponse;
import com.fluidpay.sdk.models.recurring.*;
import com.fluidpay.sdk.models.transactions.Address;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RecurringTest {
    private Random rand = new Random();
    private Connection c = new Connection();

    RecurrenceAmountRequest creAonReq = new RecurrenceAmountRequest(
            "test add on6",
            "just a simple test add on",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );
    RecurrenceAmountRequest updAonReq = new RecurrenceAmountRequest(
            "update add on6",
            "just a simple update add on",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );

    RecurrenceAmountRequest creDisReq = new RecurrenceAmountRequest(
            "test discount6",
            "just a simple test discount",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );
    RecurrenceAmountRequest updDisReq = new RecurrenceAmountRequest(
            "update discount6",
            "just a simple update discount",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    @Test
    void testAddOn() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        RecurrenceResponse creAonRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDON, id, false, true);
            creAonRes = fp.createAddOn(creAonReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creAonRes.getMsg());

        String aonId = creAonRes.getData().getId();
        id.put("addOnId", aonId);

        RecurrencesResponse getAonRes = new RecurrencesResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
            getAonRes = fp.getAddOn();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getAonRes.getMsg());

        RecurrencesResponse getAonsRes = new RecurrencesResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDONS, id, false, true);
            getAonsRes = fp.getAddOns();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getAonsRes.getMsg());
        assertNotEquals(0, getAonsRes.getTotalCount());

        RecurrenceResponse updAonRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
            updAonRes = fp.updateAddOn(updAonReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updAonRes.getMsg());

        RecurrenceResponse delAonRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
            delAonRes = fp.deleteAddOn();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delAonRes.getMsg());
    }

    @Test
    void testDiscount() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        RecurrenceResponse creDisRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNT, id, false, true);
            creDisRes = fp.createDiscount(creDisReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creDisRes.getMsg());

        String disId = creDisRes.getData().getId();
        id.put("discountId", disId);

        RecurrencesResponse getDisRes = new RecurrencesResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
            getDisRes = fp.getDiscount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getDisRes.getMsg());
        assertEquals("just a simple test discount", getDisRes.getData()[0].getDescription());

        RecurrencesResponse getDissRes = new RecurrencesResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNTS, id, false, true);
            getDissRes = fp.getDiscounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getDissRes.getMsg());
        assertNotEquals(0, getDissRes.getTotalCount());

        RecurrenceResponse updDisRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
            updDisRes = fp.updateDiscount(updDisReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updDisRes.getMsg());

        RecurrenceResponse delDisRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
            delDisRes = fp.deleteDiscount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delDisRes.getMsg());
    }

    private CreateCustomerRequest creCusReq = new CreateCustomerRequest(
            "test customer description",
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

    RecurrenceAmountRequest tempAonReq = new RecurrenceAmountRequest(
            "temp add on8",
            "just a simple test add on",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );
    RecurrenceAmountRequest tempDisReq = new RecurrenceAmountRequest(
            "temp discount8",
            "just a simple test discount",
            rand.nextInt(1000)+1,
            rand.nextInt(50)+1
    );

    @Test
    void testPlanAndSubscription() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        RecurrenceResponse creAonRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.ADDON, id, false, true);
            creAonRes = fp.createAddOn(tempAonReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RecurrenceResponse creDisRes = new RecurrenceResponse();
        try {
            fp.connection = c.init(ConnectionType.DISCOUNT, id, false, true);
            creDisRes = fp.createDiscount(tempDisReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerResponse creCusRes = new CustomerResponse();
        try {
            fp.connection = c.init(ConnectionType.CUSTOMER, id, false, true);
            creCusRes = fp.createCustomer(creCusReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String aonId = creAonRes.getData().getId();
        String disId = creDisRes.getData().getId();
        String cusId = creCusRes.getData().getId();

        id.put("addOnId", aonId);
        id.put("discountId", disId);
        id.put("customerId", cusId);

        OptionalRecurringAmountRequest[] aonOptRecReq = new OptionalRecurringAmountRequest[]{new OptionalRecurringAmountRequest(
                aonId,
                "add on for a subscription",
                "this will add to the cost of the subscription",
                100,
                0
        )};

        OptionalRecurringAmountRequest[] disOptRecReq = new OptionalRecurringAmountRequest[]{new OptionalRecurringAmountRequest(
                disId,
                "discount for a subscription",
                "this will discount the cost of the subscription",
                50,
                0
        )};

        PlanRequest crePlaReq = new PlanRequest(
                "test plan",
                "just a simple test plan",
                100,
                1,
                "twice_monthly",
                "1,15",
                0
        );
        crePlaReq.setAddOns(aonOptRecReq);
        crePlaReq.setDiscounts(disOptRecReq);

        PlanRequest updPlaReq = new PlanRequest(
                "update plan",
                "just a simple update",
                150,
                1,
                "twice_monthly",
                "1,15",
                0
        );
        updPlaReq.setDiscounts(disOptRecReq);
        updPlaReq.setAddOns(aonOptRecReq);

        PlanResponse crePlaRes = new PlanResponse();
        try {
            fp.connection = c.init(ConnectionType.PLAN, id, false, true);
            crePlaRes = fp.createPlan(crePlaReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", crePlaRes.getMsg());

        String plaId = crePlaRes.getData().getId();
        id.put("planId", plaId);

        PlansResponse getPlaRes = new PlansResponse();
        try {
            fp.connection = c.init(ConnectionType.PLANID, id, false, true);
            getPlaRes = fp.getPlan();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getPlaRes.getMsg());

        PlansResponse getPlasRes = new PlansResponse();
        try {
            fp.connection = c.init(ConnectionType.PLANS, id, false, true);
            getPlasRes = fp.getPlans();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getPlasRes.getMsg());
        assertNotEquals(0, getPlasRes.getTotalCount());

        PlanResponse updPlaRes = new PlanResponse();
        try {
            fp.connection = c.init(ConnectionType.PLANID, id, false, true);
            updPlaRes = fp.updatePlan(updPlaReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updPlaRes.getMsg());
        assertEquals("update plan", updPlaRes.getData().getName());

        // Subscription section

        SubscriptionRequest creSubReq = new SubscriptionRequest(
                plaId,
                "some description to describe the subscription",
                new IdData(cusId),
                100,
                1,
                "twice_monthly",
                "1,15",
                0,
                "2018-11-21"
        );
        creSubReq.setDiscounts(disOptRecReq);

        SubscriptionRequest updSubReq = new SubscriptionRequest(
                plaId,
                "some update to the subscription",
                new IdData(cusId),
                100,
                1,
                "twice_monthly",
                "1,15",
                0,
                "2018-11-21"
        );
        updSubReq.setDiscounts(disOptRecReq);

        SubscriptionResponse creSubRes = new SubscriptionResponse();
        try {
            fp.connection = c.init(ConnectionType.SUBSCRIPTION, id, false, true);
            creSubRes = fp.createSubscription(creSubReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creSubRes.getMsg());

        String subId = creSubRes.getData().getId();
        id.put("subscriptionId", subId);

        SubscriptionsResponse getSubRes = new SubscriptionsResponse();
        try {
            fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
            getSubRes = fp.getSubscription();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getSubRes.getMsg());
        assertEquals("twice_monthly", getSubRes.getData()[0].getBillingFrequency());

        SubscriptionResponse updSubRes = new SubscriptionResponse();
        try {
            fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
            updSubRes = fp.updateSubscription(updSubReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updSubRes.getMsg());
        assertEquals("some update to the subscription", updSubRes.getData().getDescription());

        SubscriptionResponse delSubRes = new SubscriptionResponse();
        try {
            fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
            delSubRes = fp.deleteSubscription();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delSubRes.getMsg());

        PlanResponse delPlaRes = new PlanResponse();
        try {
            fp.connection = c.init(ConnectionType.PLANID, id, false, true);
            delPlaRes = fp.deletePlan();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delPlaRes.getMsg());

        try {
            fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
            fp.deleteAddOn();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
            fp.deleteDiscount();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
            fp.deleteCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}