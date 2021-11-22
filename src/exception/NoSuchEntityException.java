package exception;

import domain.client.UserId;
import domain.tradesman.PaymentId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException userWithId(UserId id) {
        return new NoSuchEntityException(String.format("No user found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException paymentWithId(PaymentId id) {
        return new NoSuchEntityException(String.format("No Payment transaction found with ID %d.", id.getValue()));
    }
}