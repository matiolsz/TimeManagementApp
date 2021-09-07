package com.mati.WorkManagementApp.thymeleafControllers;

import com.mati.WorkManagementApp.dao.ProjectRepository;
import com.mati.WorkManagementApp.dao.TaskRepository;
import com.mati.WorkManagementApp.entities.Project;
import com.mati.WorkManagementApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectControllerTL {

    @Autowired
    ProjectService projectService;

    private ProjectControllerTL(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project,  Model model){
        projectService.create(project);
        return "redirect:/projects";
    }

}
