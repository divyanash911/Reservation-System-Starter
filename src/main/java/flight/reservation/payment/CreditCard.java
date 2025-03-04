package flight.reservation.payment;

import java.util.Date;

/**
 * Credit Card payment strategy.
 */
public class CreditCard implements Payment {
    private double balance;
    private String number;
    private Date expiryDate;
    private String cvv;
    private boolean valid;

    public CreditCard(String number, Date expiryDate, String cvv) {
        this.balance = 100000; // Dummy balance
        this.number = number;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        validateCard();
    }

    private void validateCard() {
        this.valid = number.length() > 0 && expiryDate.getTime() > System.currentTimeMillis() && !cvv.equals("000");
    }

    @Override
    public boolean processPayment(double amount) {
        if (!valid || balance < amount) {
            return false;
        }
        balance -= amount;
        System.out.println("Paid " + amount + " using Credit Card.");
        return true;
    }
}
