package domain.client;

import exception.UnvalidEmailException;
import service.EmailValidationService;
import service.RegistrationHandlerService;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public final class RegistrationHandler implements RegistrationHandlerService<UserInformation, UserId> {

    private final UserRepository userRepository;
    EmailValidationService validateUserEmail ;
    private PropertyChangeSupport support;

    public RegistrationHandler(UserRepository userRepository) {
        support = new PropertyChangeSupport(this);
        this.userRepository = userRepository;
    }

    public UserId handle(UserInformation createUser) {
        final UserId currentUserId = userRepository.currentId();
        final UserId userId = userRepository.nextIdentity();

        User user = new User(userId, createUser.getLastname(), createUser.getFirstname(), createUser.getEmail());

        if(validateUserEmail.isValid(user.getEmail())) {
            support.firePropertyChange("ValidateUserRegistration", currentUserId,userId);
            userRepository.add(user);
        }else{
            throw UnvalidEmailException.withEmail(user);
        }
        return userId;

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }



}