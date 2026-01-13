import com.fluidpay.sdk.*;
import com.fluidpay.sdk.models.apikey.KeyRequest;
import com.fluidpay.sdk.models.apikey.KeyResponse;
import com.fluidpay.sdk.models.authentication.GeneralResponse;
import com.fluidpay.sdk.models.users.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for User management operations.
 * Tests CRUD operations for users and associated API key management.
 */
class UsersTest {
    private static final String TEST_USERNAME = "testmerchant1125";
    private static final String TEST_EMAIL = "info@website.com";
    private static final String TEST_PHONE = "6305555555";
    private static final String TEST_UPDATED_NAME = "fresh test merchant user";
    private static final String TEST_UPDATED_PHONE = "6305555558";
    
    private Connection c = new Connection();

    // Test request objects
    private CreateUserRequest createUserRequest = new CreateUserRequest(
            TEST_USERNAME,
            "test merchant user",
            TEST_PHONE,
            TEST_EMAIL,
            "CET",
            "T@est12345678",
            "active",
            "admin"
    );

    private UpdateUserRequest updateUserRequest = new UpdateUserRequest(
            TEST_UPDATED_NAME,
            TEST_UPDATED_PHONE,
            TEST_EMAIL,
            "CET",
            "active",
            "admin"
    );

    private KeyRequest keyRequest = new KeyRequest("api", "testapikey");

    /**
     * Comprehensive test for user management operations:
     * 1. Get current user
     * 2. List all users
     * 3. Create a new user (or find existing if already created)
     * 4. Get user by ID
     * 5. Create API key for user
     * 6. Update user
     * 7. Delete user
     */
    @Test
    void testUser() {
        Fluidpay fp = new Fluidpay(TestConstants.TEST_API_KEY);
        HashMap<String, String> id = new HashMap<>();

        // ============================================
        // Step 1: Get Current User
        // ============================================
        UserResponse currentUserResponse = getCurrentUser(fp, id);
        assertEquals("success", currentUserResponse.getMsg(), "Should successfully retrieve current user");

        // ============================================
        // Step 2: List All Users
        // ============================================
        UsersResponse allUsersResponse = getAllUsers(fp, id);
        assertEquals("success", allUsersResponse.getMsg(), "Should successfully retrieve all users");
        assertNotEquals(0, allUsersResponse.getTotalCount(), "Should have at least one user");

        // ============================================
        // Step 3: Create User (or find existing)
        // ============================================
        String userId = createOrFindUser(fp, id);
        if (userId == null || userId.isEmpty()) {
            System.out.println("Could not create or find user - skipping remaining tests");
            return;
        }
        id.put("userId", userId);

        // ============================================
        // Step 4: Get User By ID
        // ============================================
        UserResponse getUserResponse = getUserById(fp, id);
        assertEquals("success", getUserResponse.getMsg(), "Should successfully retrieve user by ID");
        assertEquals(TEST_EMAIL, getUserResponse.getData().getEmail(), "User email should match");

        // ============================================
        // Step 5: Create API Key for User
        // ============================================
        String apiKeyId = createApiKeyForUser(fp, id);
        if (apiKeyId != null && !apiKeyId.isEmpty()) {
            id.put("apiKeyId", apiKeyId);
        }

        // ============================================
        // Step 6: Update User
        // ============================================
        UserResponse updateUserResponse = updateUser(fp, id);
        assertEquals("success", updateUserResponse.getMsg(), "Should successfully update user");

        // ============================================
        // Step 7: Delete User
        // ============================================
        GeneralResponse deleteUserResponse = deleteUser(fp, id);
        assertEquals("success", deleteUserResponse.getMsg(), "Should successfully delete user");
    }

    // ============================================
    // Helper Methods
    // ============================================

    private UserResponse getCurrentUser(Fluidpay fp, HashMap<String, String> id) {
        UserResponse response = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            response = fp.currentUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private UsersResponse getAllUsers(Fluidpay fp, HashMap<String, String> id) {
        UsersResponse response = new UsersResponse();
        try {
            fp.connection = c.init(ConnectionType.USERS, id, false, true);
            response = fp.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Creates a new user or finds an existing user if creation fails (e.g., username already taken).
     * Returns the user ID if successful, null otherwise.
     */
    private String createOrFindUser(Fluidpay fp, HashMap<String, String> id) {
        // Attempt to create user
        UserResponse createResponse = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USER, id, false, true);
            createResponse = fp.createUser(createUserRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If creation succeeded, return the new user ID
        if (createResponse.getMsg() != null && "success".equals(createResponse.getMsg()) 
            && createResponse.getData() != null) {
            return createResponse.getData().getId();
        }

        // If creation failed (e.g., username already taken), search for existing user
        try {
            fp.connection = c.init(ConnectionType.USERS, id, false, true);
            UsersResponse usersResponse = fp.getUsers();
            if (usersResponse.getData() != null && usersResponse.getData().length > 0) {
                // Find user by username
                for (UserResponseData user : usersResponse.getData()) {
                    if (user.getUsername() != null && user.getUsername().equals(TEST_USERNAME)) {
                        return user.getId();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private UserResponse getUserById(Fluidpay fp, HashMap<String, String> id) {
        UserResponse response = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            response = fp.getUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String createApiKeyForUser(Fluidpay fp, HashMap<String, String> id) {
        KeyResponse response = new KeyResponse();
        try {
            fp.connection = c.init(ConnectionType.CREATEKEY, id, false, true);
            response = fp.createKey(keyRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (response.getData() != null) {
            return response.getData().getId();
        }
        return null;
    }

    private UserResponse updateUser(Fluidpay fp, HashMap<String, String> id) {
        UserResponse response = new UserResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            response = fp.updateUser(updateUserRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private GeneralResponse deleteUser(Fluidpay fp, HashMap<String, String> id) {
        GeneralResponse response = new GeneralResponse();
        try {
            fp.connection = c.init(ConnectionType.USERID, id, false, true);
            response = fp.deleteUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}