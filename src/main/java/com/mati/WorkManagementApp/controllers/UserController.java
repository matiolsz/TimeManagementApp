package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.entities.User;
import com.mati.WorkManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@RequestParam Long id){
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }

    @PutMapping
    public User put(@RequestBody User user){
        return userService.put(user);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String roomNotFound() {
        return "Nie ma takiego rekordu";
    }

}
