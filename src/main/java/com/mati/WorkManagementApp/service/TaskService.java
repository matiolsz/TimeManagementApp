package com.mati.WorkManagementApp.service;

import com.google.common.collect.Lists;
import com.mati.WorkManagementApp.dao.TaskRepository;
import com.mati.WorkManagementApp.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    private boolean existsById(Long id){
        return taskRepository.existsById(id);
    }

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return Lists.newArrayList(taskRepository.findAll());
    }

    public Task get(Long id) {
        if(taskRepository.existsById(id)) {
            return taskRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void delete(Long id){
        if(taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public Task put(Task task) {
        return taskRepository.save(task);
    }
}


