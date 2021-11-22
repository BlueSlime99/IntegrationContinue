package service;

public interface PaymentHandlerService <C extends Command, R> {
    R handle(C command);

}
