import com.fluidpay.sdk.Connection;
import com.fluidpay.sdk.ConnectionType;
import com.fluidpay.sdk.Fluidpay;
import com.fluidpay.sdk.TestConstants;
import com.fluidpay.sdk.models.terminals.TerminalsResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Terminal operations.
 * Tests retrieval of all terminals associated with the gateway account.
 */
class TerminalsTest {
    private Connection c = new Connection();

    /**
     * Test retrieving all terminals.
     * Verifies that the API returns a successful response with terminal data.
     */
    @Test
    void testGetTerminals() {
        Fluidpay fp = new Fluidpay(TestConstants.TEST_API_KEY);
        HashMap<String, String> id = new HashMap<>();

        // ============================================
        // Get All Terminals
        // ============================================
        TerminalsResponse response = getTerminals(fp, id);
        
        assertEquals("success", response.getStatus(), "Should successfully retrieve terminals");
        assertNotEquals(0, response.getTotalCount(), "Should have at least one terminal");
        
        if (response.getData() != null && response.getData().length > 0) {
            // Verify that we have terminal data
            assertNotNull(response.getData()[0].getId(), "Terminal should have an ID");
        }
    }

    // ============================================
    // Helper Methods
    // ============================================

    /**
     * Helper method to retrieve all terminals.
     */
    private TerminalsResponse getTerminals(Fluidpay fp, HashMap<String, String> id) {
        TerminalsResponse response = new TerminalsResponse();
        try {
            fp.connection = c.init(ConnectionType.TERMINALS, id, false, true);
            response = fp.getTerminals();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}