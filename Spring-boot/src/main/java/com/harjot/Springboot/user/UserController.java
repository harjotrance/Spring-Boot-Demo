package com.harjot.Springboot.user;

import com.harjot.Springboot.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping("/users")

    public List<User> retriveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")

    public User retriveUser (@PathVariable int id) throws UserNotFoundException {

        User user = userService.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id-" + id + " dose not exist.");

        return user;

    }

    @PostMapping("/users")

    public ResponseEntity<Object> createUser (@Valid @RequestBody User user) {
       User savedUser = userService.save(user);


        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build ();

    }

    @DeleteMapping ("/users/{id}")

    public void deleteUser (@PathVariable int id) throws UserNotFoundException {

        User user = userService.deleteById(id);

        if(user==null)
            throw new UserNotFoundException("id-" + id + " dose not exist.");


    }

}
