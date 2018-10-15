import com.fluidpay.sdk.Auth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthTest {
    @Test
    void testAuth() {
        Auth auth = new Auth(1, "myApiKey");
        assertEquals("myApiKey", auth.getAuthorization());

        auth.setAuth(2, "myJWTToken");
        assertEquals("Bearer myJWTToken", auth.getAuthorization());
    }
}