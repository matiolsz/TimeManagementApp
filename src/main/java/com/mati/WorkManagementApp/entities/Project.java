package com.mati.WorkManagementApp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;
    private String projectName;
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;


    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project(String projectName, List<Task> taskList) {
        this.projectName = projectName;
        this.tasks = taskList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTaskList() {
        return tasks;
    }

    public void setTaskList(List<Task> taskList) {
        this.tasks = taskList;
    }
}
