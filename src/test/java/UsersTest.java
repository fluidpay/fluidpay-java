import com.fluidpay.sdk.*;
import com.fluidpay.sdk.models.apikey.KeyRequest;
import com.fluidpay.sdk.models.apikey.KeyResponse;
import com.fluidpay.sdk.models.authentication.GeneralResponse;
import com.fluidpay.sdk.models.users.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    private Connection c = new Connection();

    private CreateUserRequest creUsrReq = new CreateUserRequest(
            "testmerchant1125",
            "test merchant user",
            "6305555555",
            "info@website.com",
            "CET",
            "T@est12345678",
            "active",
            "admin"
    );

    private ChangePasswordRequest chPwReq = new ChangePasswordRequest(
            "testmerchant1125",
            "T@est12345678",
            "T@est123456789*"
    );

    private UpdateUserRequest updUsrReq = new UpdateUserRequest(
            "fresh test merchant user",
            "6305555558",
            "info@website.com",
            "CET",
            "active",
            "admin"
    );

    private KeyRequest keyReq = new KeyRequest(
            "api",
            "testapikey"
    );

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    @Test
    void testUser() {
        Fluidpay fp = new Fluidpay(TestAPIkey);
        HashMap<String, String> id = new HashMap<>();

        UserResponse currUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            currUsrRes = fp.currentUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", currUsrRes.getMsg());

        UsersResponse getUsrsRes = new UsersResponse();
        try {
            fp.connection = c.init(ConnectionType.USERS, id, false, true);
            getUsrsRes = fp.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getUsrsRes.getMsg());
        assertNotEquals(0, getUsrsRes.getTotalCount());

        UserResponse creUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            creUsrRes = fp.createUser(creUsrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", creUsrRes.getMsg());

        String usrId = creUsrRes.getData().getId();
        id.put("userId", usrId);

        UserResponse getUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            getUsrRes = fp.getUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", getUsrRes.getMsg());
        assertEquals("info@website.com", getUsrRes.getData().getEmail());

        KeyResponse creKeyRes = new KeyResponse();
        try {
            fp.connection = c.init(ConnectionType.CREATEKEY, id, false, true);
            creKeyRes = fp.createKey(keyReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String keyId = creKeyRes.getData().getId();
        String newKey = creKeyRes.getData().getApiKey();
        id.put("apiKeyId", keyId);

        /*
        UserResponse chPwRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.CHANGEPASSWORD, id, false, true);
            chPwRes = fp.changePassword(chPwReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", chPwRes.getMsg());
        */

        UserResponse updUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            updUsrRes = fp.updateUser(updUsrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", updUsrRes.getMsg());

        GeneralResponse delUsrRes = new GeneralResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            delUsrRes = fp.deleteUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", delUsrRes.getMsg());
    }
}