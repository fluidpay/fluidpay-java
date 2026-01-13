import com.fluidpay.sdk.Auth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthTest {
    @Test
    void testAuth() {
        Auth auth = new Auth("myApiKey");
        assertEquals("myApiKey", auth.getAuthorization());
        
        auth.setAuth("newApiKey");
        assertEquals("newApiKey", auth.getAuthorization());
    }
}