package com.aiu.schedule.controllers;

import com.aiu.schedule.models.Groups;
import com.aiu.schedule.models.Professor;
import com.aiu.schedule.models.Subject;
import com.aiu.schedule.repo.GroupRepository;
import com.aiu.schedule.repo.ProfessorRepository;
import com.aiu.schedule.repo.SubjectRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        Iterable<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        Iterable<Groups> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
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
        model.addAttribute("title", "Add data");
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

    @PostMapping("/professors-add")
    public String addPostProf(@RequestParam String name, @RequestParam String email, Model model){
        Professor professor = new Professor(name, email);
        professorRepository.save(professor);
        return "redirect:/professors";
    }

    @PostMapping("/subjects-add")
    public String addPostSub(@RequestParam String name, Model model){
        Subject subject = new Subject(name);
        subjectRepository.save(subject);
        return "redirect:/subjects";
    }

    @PostMapping("/groups-add")
    public String addPostGroup(@RequestParam String name, Model model){
        Groups groups = new Groups(name);
        groupRepository.save(groups);
        return "redirect:/groups";
    }

    @GetMapping("/professors/{id}")
    public String allProfDetail(@PathVariable(value = "id") long id, Model model) {
        if(!professorRepository.existsById(id)){
            return "redirect:/professors";
        }
        Optional<Professor> professor = professorRepository.findById(id);
        ArrayList<Professor> res = new ArrayList<>();
        professor.ifPresent(res::add);
        model.addAttribute("professor", res);
        return "prof-details";
    }

    @GetMapping("/professors/{id}/edit")
    public String allProfEdit(@PathVariable(value = "id") long id, Model model) {
        if(!professorRepository.existsById(id)){
            return "redirect:/professors";
        }
        Optional<Professor> professor = professorRepository.findById(id);
        ArrayList<Professor> res = new ArrayList<>();
        professor.ifPresent(res::add);
        model.addAttribute("professor", res);
        return "prof-edit";
    }

    @PostMapping("/professors/{id}/edit")
    public String addProfUdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String email, Model model) throws NotFoundException {
        Professor professor = professorRepository.findById(id).orElseThrow(()->new NotFoundException("id not found"+id));
        professor.setName(name);
        professor.setEmail(email);
        professorRepository.save(professor);
        return "redirect:/professors";
    }

    @PostMapping("/professors/{id}/remove")
    public String addProfDelete(@PathVariable(value = "id") long id, Model model) throws NotFoundException {
        Professor professor = professorRepository.findById(id).orElseThrow(()->new NotFoundException("id not found"+id));
        professorRepository.delete(professor);
        return "redirect:/professors";
    }
}
