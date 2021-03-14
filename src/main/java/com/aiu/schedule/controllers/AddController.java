package com.aiu.schedule.controllers;

import com.aiu.schedule.models.Professor;
import com.aiu.schedule.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/all")
    public String allMain(Model model){
        return "all-main-prof";
    }
    @GetMapping("/all/professors")
    public String allProf(Model model){
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        return "all-main-prof";
    }
}
