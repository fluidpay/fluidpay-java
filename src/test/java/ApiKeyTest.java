import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.models.apikey.KeyRequest;
import com.fluidpay.sdk.models.apikey.KeyResponse;
import com.fluidpay.sdk.models.apikey.KeysResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ApiKeyTest {
    private KeyRequest keyReq = new KeyRequest(
          "api",
          "testapikey"
    );

    private Connection c = new Connection();

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    @Test
    void testKey() {
        Fluidpay fp = new Fluidpay(TestAPIkey);

        HashMap<String, String> id = new HashMap<>();

        KeyResponse creKeyRes = new KeyResponse();
        try {
            fp.connection = c.init(ConnectionType.CREATEKEY, id, false, true);
            creKeyRes = fp.createKey(keyReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creKeyRes.getMsg());

        KeysResponse getKeysRes = new KeysResponse();
        try {
            fp.connection = c.init(ConnectionType.GETKEYS, id, false, true);
            getKeysRes = fp.getKeys();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotEquals(0, getKeysRes.getTotalCount());

        String keyId = getKeysRes.getData()[getKeysRes.getData().length-1].getApiKey();
        id.put("apiKeyId", keyId);

        KeyResponse delKeyRes = new KeyResponse();
        try {
            fp.connection = c.init(ConnectionType.DELETEKEY, id, false, true);
            delKeyRes = fp.deleteKey();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delKeyRes.getMsg());
    }
}