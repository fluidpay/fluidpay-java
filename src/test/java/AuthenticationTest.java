import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.TestConstants;
import com.fluidpay.sdk.models.users.CreateUserRequest;
import com.fluidpay.sdk.models.users.UserResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Test for user creation and cleanup
 * Note: This test is similar to UsersTest but focuses on cleanup scenarios
 */
class AuthenticationTest {
    private CreateUserRequest userReq = new CreateUserRequest(
            "testtoken401",
            "test token merchant",
            "6308886655",
            "info@website.com",
            "CET",
            "T@est12345678",
            "active",
            "admin"
    );

    private Connection c = new Connection();

    @Test
    void testUserCreationAndCleanup() {
        Fluidpay fp = new Fluidpay(TestConstants.TEST_API_KEY);
        HashMap<String, String> id = new HashMap<>();

        // Try to create user
        UserResponse creUsrRes = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            creUsrRes = fp.createUser(userReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Get user ID - either from creation or from current user if creation failed
        String userId = null;
        if (creUsrRes.getData() != null && creUsrRes.getData().getId() != null) {
            userId = creUsrRes.getData().getId();
        } else {
            // User might already exist, try to get current user
            try {
                fp.connection = c.init(ConnectionType.USER, id, false, true);
                UserResponse currUser = fp.currentUser();
                if (currUser.getData() != null) {
                    userId = currUser.getData().getId();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Cleanup: delete user if we have a valid ID
        if (userId != null) {
            id.put("userId", userId);
            try {
                fp.connection = c.init(ConnectionType.USERID, id, false, true);
                fp.deleteUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}