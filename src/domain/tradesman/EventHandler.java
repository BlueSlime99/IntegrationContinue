package domain.tradesman;

import infrastructure.InMemoryPaymentRepository;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;

public class EventHandler implements PropertyChangeListener {
    PaymentProcess startPaymentProcess;
    BillingInformation billingInfo;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

            System.out.println("Process Payment lunched, please enter your card Information");
            Scanner input = new Scanner(System.in);
            startPaymentProcess  = new PaymentProcess(new InMemoryPaymentRepository());
            billingInfo = new BillingInformation();
            billingInfo.sendBillingInformation(input);
            PaymentId pId = startPaymentProcess.handle(billingInfo);
    }

}
