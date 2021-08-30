package com.mati.WorkManagementApp.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long workTimeId;
    private LocalDate date;
    private LocalTime workStart;
    private LocalTime workEnd;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User user;

    public WorkTime() {
    }

    public WorkTime(LocalDate date, LocalTime workStart, LocalTime workEnd) {
        this.date = date;
        this.workStart = workStart;
        this.workEnd = workEnd;
    }

    public WorkTime(LocalDate date, LocalTime workStart, LocalTime workEnd, Task task, User user) {
        this.date = date;
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.task = task;
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalTime workStart) {
        this.workStart = workStart;
    }

    public LocalTime getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(LocalTime workEnd) {
        this.workEnd = workEnd;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
