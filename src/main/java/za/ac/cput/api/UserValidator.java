package za.ac.cput.api;

import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.security.SecurityConfig;

public class UserValidator {

    public static String hashPassword(String password)
    {
        return SecurityConfig.bCryptPasswordEncoder().encode(password);
    }

    public static User validateUserCredential(Boolean doesUserExist, User userToValidate, User existingUser)
    {
        if(!doesUserExist) return null;

        User userResponse;
        String passwordError = "";
        String usernameError = "";

        if(!userToValidate.getUsername().equalsIgnoreCase(existingUser.getUsername()))
        {
            usernameError = "Username is not registered.";
        }

        if(!hashPassword(userToValidate.getPassword()).equals(existingUser.getPassword()))
        {
            passwordError = "Password is incorrect.";
        }

        return UserFactory.build(
                existingUser.getUserId(),
                existingUser.getUsername(),
                "",
                existingUser.getUserType(),
                usernameError,
                passwordError
        );
    }
}
