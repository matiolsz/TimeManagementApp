package com.mati.WorkManagementApp.service;

import com.google.common.collect.Lists;
import com.mati.WorkManagementApp.dao.UserRepository;
import com.mati.WorkManagementApp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    private boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User get(Long id) {
        if(userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void delete(Long id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public User put(User user) {
        return userRepository.save(user);
    }
}


