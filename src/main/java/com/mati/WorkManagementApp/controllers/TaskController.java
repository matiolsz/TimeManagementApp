package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.dao.TaskRepository;
import com.mati.WorkManagementApp.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public String showTasks(Model model){
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks/list-tasks";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "tasks/new-task";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Task task){
        taskRepository.save(task);
        return "redirect:/tasks";
    }


}
