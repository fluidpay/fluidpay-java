import com.fluidpay.sdk.*;
import com.fluidpay.sdk.models.authentication.*;
import com.fluidpay.sdk.models.users.CreateUserRequest;
import com.fluidpay.sdk.models.users.UserResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationTest {
    private CreateUserRequest keyUsrReq = new CreateUserRequest(
            "testtoken401",
            "test token merchant",
            "6308886655",
            "info@website.com",
            "CET",
            "T@est12345678",
            "active",
            "admin"
    );
    private JWTTokenRequest tokReq = new JWTTokenRequest(
            "testtoken401",
            "T@est12345678"
    );
    private ForgottenUsernameRequest forUsrReq = new ForgottenUsernameRequest(
            "info@website.com"
    );
    private ForgottenPasswordRequest forPwReq = new ForgottenPasswordRequest(
            "testtoken401"
    );

    private Connection c = new Connection();

    private final String TestAPIkey = "api_0wUsHIlrkK1I6ADno5MfT10UjhR";

    @Test
    void TestToken() {
        Fluidpay fp = new Fluidpay(TestAPIkey);

        HashMap<String, String> id = new HashMap<>();

        UserResponse creUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            creUsrRes = fp.createUser(keyUsrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JWTTokenResponse tokRes = new JWTTokenResponse();
        try {
            fp.connection = c.init(ConnectionType.OBTAINJWT, id, false, true);
            tokRes = fp.obtainJWT(tokReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", tokRes.getStatus());

        GeneralResponse forUsrRes = new GeneralResponse();
        try {
            fp.connection = c.init(ConnectionType.FORGOTTENUSERNAME, id, false, true);
            forUsrRes = fp.forgottenUsername(forUsrReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", forUsrRes.getMsg());

        GeneralResponse forPwRes = new GeneralResponse();
        try {
            fp.connection = c.init(ConnectionType.FORGOTTENPASSWORD, id, false, true);
            forPwRes = fp.forgottenPassword(forPwReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("success", forPwRes.getMsg());

        /*
        try {
            fp.connection = c.init(ConnectionType.TOKENLOGOUT, id, false, true);
            fp.tokenLogout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        id.put("userId", creUsrRes.getData().getId());

        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            fp.deleteUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}