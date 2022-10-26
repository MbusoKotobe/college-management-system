package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.User;
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
}
