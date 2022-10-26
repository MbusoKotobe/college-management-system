package za.ac.cput.factory;

import org.apache.commons.digester.annotations.rules.FactoryCreate;
import za.ac.cput.entity.User;
import za.ac.cput.utility.Utilities;

public class UserFactory {
    public static User build(String userId, String username, String password, String userType, String usernameErrorMessage, String passwordErrorMessae)
    {
        Utilities.checkStringParam("userId", userId);
        Utilities.checkStringParam("username", username);
        Utilities.checkStringParam("password", password);
        Utilities.checkStringParam("userType", userType);
        return User.builder().userId(userId)
                      .username(username)
                      .password(password)
                      .userType(userType)
                      .usernameErrorMessage(usernameErrorMessage)
                      .passwordErrorMessage(passwordErrorMessae).build();
    }
}
