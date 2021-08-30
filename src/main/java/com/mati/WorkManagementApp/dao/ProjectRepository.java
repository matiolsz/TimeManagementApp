package com.mati.WorkManagementApp.dao;

import com.mati.WorkManagementApp.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

}
