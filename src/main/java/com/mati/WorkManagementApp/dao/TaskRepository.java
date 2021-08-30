package com.mati.WorkManagementApp.dao;

import com.mati.WorkManagementApp.entities.Project;
import com.mati.WorkManagementApp.entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    public List<Task> findAll();

}
