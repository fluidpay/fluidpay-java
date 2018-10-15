import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.models.terminals.TerminalsResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TerminalsTest {
    private Connection c = new Connection();

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    @Test
    void testTerminals() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        TerminalsResponse getTerRes = new TerminalsResponse();
        try {
            fp.connection = c.init(ConnectionType.TERMINALS, id, false, true);
            getTerRes = fp.getTerminals();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getTerRes.getMsg());
        assertNotEquals(0, getTerRes.getTotalCount());
    }
}