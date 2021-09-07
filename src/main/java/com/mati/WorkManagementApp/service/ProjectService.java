package com.mati.WorkManagementApp.service;

import com.google.common.collect.Lists;
import com.mati.WorkManagementApp.dao.ProjectRepository;
import com.mati.WorkManagementApp.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    private boolean existsById(Long id){
        return projectRepository.existsById(id);
    }

    public Project create(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return Lists.newArrayList(projectRepository.findAll());
    }

    public Project get(Long id) {
        if(projectRepository.existsById(id)) {
            return projectRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void delete(Long id){
        if(projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public Project put(Project project) {
        return projectRepository.save(project);
    }
}


