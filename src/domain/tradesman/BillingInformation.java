package domain.tradesman;

import service.Command;

import java.util.Scanner;

public class BillingInformation implements Command {

    private long cardNumber;
    private String cardOwner;
    private int threeDigit;

    public BillingInformation() {
    }

    public BillingInformation sendBillingInformation(Scanner input) {

        BillingInformation billingInfo = new BillingInformation();
        System.out.println("enter your card Number");
        long cardNumber = input.nextLong();
        System.out.println("enter ThreeDigit code");
        int threeDigit = input.nextInt();
        System.out.println("enter Name Owner");
        String cardOwner = input.next();

        billingInfo.cardNumber = cardNumber;
        billingInfo.cardOwner = cardOwner;
        billingInfo.threeDigit = threeDigit;

        return billingInfo;
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


}
