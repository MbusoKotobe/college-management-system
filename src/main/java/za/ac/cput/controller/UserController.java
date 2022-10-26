package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.IUserService;

import java.util.List;

/***
 * UserControllerTest.java
 * Controller for User
 * @author Mbuso Kotobe (218040385)
 * Date: 21 August 2022
 */
@Slf4j
@RestController
@RequestMapping("college-management-system/user/")
public class UserController {

    private final IUserService service;

    @Autowired
    public UserController (IUserService service)
    {
        this.service = service;
    }

    public ResponseEntity<User> save(@RequestBody User user)
    {
        User userReturned = null;
        try{
            userReturned = service.save(UserFactory.build(
                    user.getUserId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getUserType(),
                    "",
                    ""
            ));
        }
        catch(IllegalArgumentException exception)
        {
            log.info("User Save: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userReturned);
    }

    public ResponseEntity<User> read(@PathVariable String userId)
    {
        User userReturned = service.read(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(userReturned);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(User user)
    {
        User userAuthResults = null;
        try{
            userAuthResults = service.login(user);
        }
        catch(IllegalArgumentException exception)
        {
            log.info("User login: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(userAuthResults == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        else return ResponseEntity.ok(userAuthResults);
    }

    @PostMapping("signup")
    public ResponseEntity<User> signup(User user)
    {
        User userReturned = null;
        try{
            userReturned = service.signup(user);
        }
        catch(IllegalArgumentException exception)
        {
            log.info("User Login: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userReturned);
    }

}
