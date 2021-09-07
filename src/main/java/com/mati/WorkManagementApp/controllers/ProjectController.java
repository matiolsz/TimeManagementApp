package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.entities.Project;
import com.mati.WorkManagementApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    private ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }

    @GetMapping
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project get(@RequestParam Long id){
        return projectService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        projectService.delete(id);
    }

    @PutMapping
    public Project put(@RequestBody Project project){
        return projectService.put(project);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String roomNotFound() {
        return "Nie ma takiego rekordu";
    }

}
