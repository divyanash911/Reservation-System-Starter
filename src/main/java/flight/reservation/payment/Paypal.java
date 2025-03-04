package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;

/**
 * PayPal payment strategy.
 */
public class Paypal implements Payment {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private String username;
    private String email;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    public Paypal(String username) {
        this.username = username;
        this.email = DATA_BASE.get(username);
    }

    private boolean isValid() {
        return email != null;
    }

    @Override
    public boolean processPayment(double amount) {
        if (isValid()) {
            System.out.println("Paid " + amount + " using PayPal.");
            return true;
        }
        return false;
    }
}
