package io.github.hossensyedriadh.springbootdatajpacrudsql.controller;

import io.github.hossensyedriadh.springbootdatajpacrudsql.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private final CrudService crudService;

    @Autowired
    public IndexController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/")
    public ModelAndView getStudents(Model model) {
        model.addAttribute("students", crudService.getStudents());

        return new ModelAndView("index");
    }
}
