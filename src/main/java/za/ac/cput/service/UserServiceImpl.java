package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.api.UserValidator;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private IUserRepository repository;

    @Autowired
    public UserServiceImpl(IUserRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public User save(User user)
    {
        //TODO: encode password
        return repository.save(user);
    }

    @Override
    public Optional<User> read(String userId)
    {
        return repository.findById(userId);
    }

    @Override
    public void delete(User user)
    {
        repository.delete(user);
    }

    @Override
    public List<User> findAll()
    {
        return repository.findAll();
    }


    @Override
    public void deleteById(String userId)
    {
        repository.deleteById(userId);
    }

    @Override
    public Optional<User> readByUsername(String username)
    {
        return repository.findById(username);
    }

    @Override
    public User login(User user) throws IllegalArgumentException
    {
        User builtUser = UserFactory.build(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserType(),
                user.getUsernameErrorMessage(),
                user.getPasswordErrorMessage()
        );
        return UserValidator.validateUserCredential(read(builtUser.getUserId()).isPresent(),
               builtUser, read(builtUser.getUserId()).get());

    }

    @Override
    public User signup(User user) throws IllegalArgumentException
    {
        User builtUser = UserFactory.build(user.getUserId(), user.getUsername(), UserValidator.hashPassword(user.getPassword()), user.getUserType(), null, null);
        return save(builtUser);
    }
}
