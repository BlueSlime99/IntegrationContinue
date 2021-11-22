package service;

public interface RegistrationHandlerService<C extends Command, R> {
    R handle(C command);
}