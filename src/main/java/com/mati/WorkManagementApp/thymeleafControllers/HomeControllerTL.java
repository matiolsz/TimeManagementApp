package com.mati.WorkManagementApp.thymeleafControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerTL {

    @GetMapping("/")
    public String displayHome(){
        return "main/home";
    }
}
