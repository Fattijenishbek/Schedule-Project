package com.aiu.schedule.controllers;

import com.aiu.schedule.models.Professor;
import com.aiu.schedule.models.Subject;
import com.aiu.schedule.repo.ProfessorRepository;
import com.aiu.schedule.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/all")
    public String allMain(Model model){
        model.addAttribute("title", "All all");
        return "all";
    }

    @GetMapping("/professors")
    public String allProf(Model model){
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        return "all-main-prof";
    }

    @GetMapping("/subjects")
    public String allSub(Model model){
        Iterable<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "all-main-sub";
    }
}
