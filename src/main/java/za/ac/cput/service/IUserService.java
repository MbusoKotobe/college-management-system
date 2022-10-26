package za.ac.cput.service;

import za.ac.cput.entity.User;

public interface IUserService extends IService<User, String>{
    void deleteById(String userId);
}
