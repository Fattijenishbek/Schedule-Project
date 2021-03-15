package com.aiu.schedule.controllers;

import com.aiu.schedule.models.Groups;
import com.aiu.schedule.models.Professor;
import com.aiu.schedule.models.Subject;
import com.aiu.schedule.repo.GroupRepository;
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
    @Autowired
    private GroupRepository groupRepository;

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

    @GetMapping("/groups")
    public String allGroup(Model model){
        Iterable<Groups> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        return "all-main-group";
    }

    @GetMapping("/add")
    public String addMain(Model model){
        model.addAttribute("title", "All all");
        return "add";
    }

    @GetMapping("/professors-add")
    public String addProf(Model model){
        return "add-prof";
    }

    @GetMapping("/subjects-add")
    public String addSub(Model model){
        return "add-sub";
    }

    @GetMapping("/groups-add")
    public String addGroup(Model model){
        return "add-group";
    }
}
