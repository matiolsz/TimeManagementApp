package com.mati.WorkManagementApp.dao;

import com.mati.WorkManagementApp.entities.Project;
import com.mati.WorkManagementApp.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    public List<User> findAll();

}
