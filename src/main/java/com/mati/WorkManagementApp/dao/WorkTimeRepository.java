package com.mati.WorkManagementApp.dao;

import com.mati.WorkManagementApp.entities.Project;
import com.mati.WorkManagementApp.entities.WorkTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkTimeRepository extends CrudRepository<WorkTime, Long> {

    @Override
    public List<WorkTime> findAll();

}
