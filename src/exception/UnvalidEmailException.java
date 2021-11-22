package exception;

import domain.client.User;


public final class UnvalidEmailException extends RuntimeException {

    public UnvalidEmailException(String message) {
        super(message);
    }

    public static UnvalidEmailException withEmail(User user) {
        return new UnvalidEmailException(String.format("The email is not conforme %s.", user.getEmail()));
    }
}