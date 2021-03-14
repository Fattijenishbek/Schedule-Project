package com.aiu.schedule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

    @GetMapping("/all")
    public String allMain(Model model){
        return "all-main";
    }
}
