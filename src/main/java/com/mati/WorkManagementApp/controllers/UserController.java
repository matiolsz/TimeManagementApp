package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.dao.UserRepository;
import com.mati.WorkManagementApp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController{

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String showUser(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "users/list-users";
    }

    @GetMapping("/new")
    public String displayUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/new-user";
    }

    @PostMapping("/save")
    public String createUser(Model model, User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/myAccount")
    public String showMyAccount(){
        return "my-account";
    }
}
