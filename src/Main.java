import domain.client.RegistrationHandler;
import domain.client.UserId;
import domain.client.UserInformation;
import domain.tradesman.EventHandler;
import infrastructure.InMemoryUserRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EventHandler eventPayment = new EventHandler();
        RegistrationHandler userCommandHandler = new RegistrationHandler(new InMemoryUserRepository());
        Scanner info = new Scanner(System.in);
        UserInformation createUser = new UserInformation();
        createUser = createUser.sendUserInformation(info);
        userCommandHandler.addPropertyChangeListener(eventPayment);
        final UserId userId = userCommandHandler.handle(createUser);

    }
}