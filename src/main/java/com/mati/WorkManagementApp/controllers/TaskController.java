package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.entities.Task;
import com.mati.WorkManagementApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    private TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task get(@RequestParam Long id){
        return taskService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        taskService.delete(id);
    }

    @PutMapping
    public Task put(@RequestBody Task task){
        return taskService.put(task);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String roomNotFound() {
        return "Nie ma takiego rekordu";
    }

}
