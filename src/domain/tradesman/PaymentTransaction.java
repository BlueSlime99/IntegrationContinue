package domain.tradesman;

import objects.Entity;

public class PaymentTransaction implements Entity<PaymentId> {

    final private PaymentId id;
    final private long cardNumber;
    final private String cardOwner;
    final private int threeDigit;


    public PaymentTransaction(PaymentId paymentId, long cardNumber, String cardOwner, int threeDigit) {
        this.id = paymentId;
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
        this.threeDigit = threeDigit;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public int getThreeDigit() {
        return threeDigit;
    }



    @Override
    public PaymentId id() {
        return id;
    }
}
