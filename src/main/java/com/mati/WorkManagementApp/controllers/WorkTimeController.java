package com.mati.WorkManagementApp.controllers;

import com.mati.WorkManagementApp.entities.WorkTime;
import com.mati.WorkManagementApp.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/worktime")
public class WorkTimeController {

    private WorkTimeService workTimeService;

    @Autowired
    private WorkTimeController(WorkTimeService workTimeService){
        this.workTimeService = workTimeService;
    }

    @PostMapping
    public WorkTime create(@RequestBody WorkTime workTime){
        return workTimeService.create(workTime);
    }

    @GetMapping
    public List<WorkTime> getAll(){
        return workTimeService.getAll();
    }

    @GetMapping("/{id}")
    public WorkTime get(@RequestParam Long id){
        return workTimeService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        workTimeService.delete(id);
    }

    @PutMapping
    public WorkTime put(@RequestBody WorkTime workTime){
        return workTimeService.put(workTime);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String roomNotFound() {
        return "Nie ma takiego rekordu";
    }

}
