package com.mati.WorkManagementApp.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String userName;
    private String email;
    private String password;
    private String speciality;
    @OneToMany
    private List<Project> projects;
    @OneToMany
    private List<Task> tasks;
    @OneToMany
    private List<WorkTime> workTimeList;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String speciality) {
            this.userName = userName;
        this.speciality = speciality;
    }

    public User(String userName, String speciality, List<Project> projects, List<Task> tasks, List<WorkTime> workTimeList) {
        this.userName = userName;
        this.speciality = speciality;
        this.projects = projects;
        this.tasks = tasks;
        this.workTimeList = workTimeList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<WorkTime> getWorkTimeList() {
        return workTimeList;
    }

    public void setWorkTimeList(List<WorkTime> workTimeList) {
        this.workTimeList = workTimeList;
    }
}
