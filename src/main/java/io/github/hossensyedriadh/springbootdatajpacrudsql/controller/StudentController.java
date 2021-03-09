package io.github.hossensyedriadh.springbootdatajpacrudsql.controller;

import io.github.hossensyedriadh.springbootdatajpacrudsql.entity.Student;
import io.github.hossensyedriadh.springbootdatajpacrudsql.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final CrudService crudService;

    @Autowired
    public StudentController(CrudService crudService) {
        this.crudService = crudService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping(value = "/view", params = {"id"})
    public ModelAndView getStudent(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("student", crudService.getStudent(id));

        return new ModelAndView("student");
    }

    @GetMapping("/new")
    public ModelAndView newStudent(Model model) {
        model.addAttribute("student", new Student());

        return new ModelAndView("new-student");
    }

    @PostMapping("/add")
    public ModelAndView addStudent(@ModelAttribute("student") Student student) {
        crudService.addStudent(student);

        return new ModelAndView(new RedirectView("/"));
    }

    @GetMapping(value = "/update", params = {"id"})
    public ModelAndView updateStudent(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("student", crudService.getStudent(id));

        return new ModelAndView("update-student");
    }

    @PostMapping("/save-changes")
    public ModelAndView saveStudentChanges(@ModelAttribute("student") Student student) {
        crudService.updateStudent(student);

        return new ModelAndView(new RedirectView("/"));
    }

    @PostMapping(value = "/delete", params = {"id"})
    public ModelAndView deleteStudent(@RequestParam("id") Integer id) {
        crudService.deleteStudent(id);

        return new ModelAndView(new RedirectView("/"));
    }
}
