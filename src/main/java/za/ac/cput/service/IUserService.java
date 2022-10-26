package za.ac.cput.service;

import za.ac.cput.entity.User;

import java.util.Optional;

public interface IUserService extends IService<User, String>{
    void deleteById(String userId);
    Optional<User> readByUsername(String username);
    User login(User user);
    User signup(User user);
}
