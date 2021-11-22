package domain.client;

import service.Command;

import java.util.Scanner;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class UserInformation implements Command {

    private String lastname;
    private String firstname;
    private String email;


    public UserInformation() {
    }

    public UserInformation sendUserInformation(Scanner input){

        UserInformation user = new UserInformation();
        System.out.println("enter lastname");
        String lastname = input.nextLine();
        System.out.println("enter first name");
        String firstname = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();

        user.lastname = lastname;
        user.firstname = firstname;
        user.email = email;
        return user;
    }


    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

}