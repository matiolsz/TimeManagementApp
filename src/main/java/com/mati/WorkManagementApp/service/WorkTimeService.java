package com.mati.WorkManagementApp.service;

import com.google.common.collect.Lists;
import com.mati.WorkManagementApp.dao.WorkTimeRepository;
import com.mati.WorkManagementApp.entities.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WorkTimeService {

    private WorkTimeRepository workTimeRepository;

    @Autowired
    public WorkTimeService(WorkTimeRepository workTimeRepository){
        this.workTimeRepository=workTimeRepository;
    }

    private boolean existsById(Long id){
        return workTimeRepository.existsById(id);
    }

    public WorkTime create(WorkTime workTime){
        return workTimeRepository.save(workTime);
    }

    public List<WorkTime> getAll() {
        return Lists.newArrayList(workTimeRepository.findAll());
    }

    public WorkTime get(Long id) {
        if(workTimeRepository.existsById(id)) {
            return workTimeRepository.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void delete(Long id){
        if(workTimeRepository.existsById(id)) {
            workTimeRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public WorkTime put(WorkTime workTime) {
        return workTimeRepository.save(workTime);
    }
}


