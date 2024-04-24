import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionsTest {

    private Transactions transaction;

    @BeforeEach
    public void setUp() {
        transaction = new Transactions("deposit", 500.0);
    }

    @Test
    public void testGetTransactionType() {
        assertEquals("deposit", transaction.getTransactionType());
    }

    @Test
    public void testGetAmount() {
        assertEquals(500.0, transaction.getAmount());
    }

    @Test
    public void testSetTransactionType() {
        transaction.setTransactionType("withdraw");
        assertEquals("withdraw", transaction.getTransactionType());
    }

    @Test
    public void testSetAmount() {
        transaction.setAmount(1000.0);
        assertEquals(1000.0, transaction.getAmount());
    }

    @Test
    public void testToString() {
        String expected = "--------------------------------------\n" +
                "              TRANSACTION              \n" +
                "--------------------------------------\n" +
                "Type:    Deposit\n" +
                "Amount:  $500.0\n" +
                "--------------------------------------\n" +
                "\n" +
                "--------------------------------------\n";
        assertEquals(expected, transaction.toString());
    }
}

