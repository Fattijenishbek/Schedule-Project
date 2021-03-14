package com.aiu.schedule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About this Site");
        return "about";
    }

}