package com.example.appwebbellac.controller;

import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.repository.EleveRepository;
import com.example.appwebbellac.service.EleveService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class eleveController {

    @Autowired
    private EleveRepository repositoryEleve;

    @Autowired
    private EleveService service;



    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/eleves")
    public String eleve(Model model) {
        Iterable<Eleve> listEleve = repositoryEleve.getEleve();
        model.addAttribute("eleves", listEleve);
        return "eleve";
    }

    @GetMapping("/createEleve")
    public String createEleve(Model model) {
        Eleve e = new Eleve();
        model.addAttribute("eleve", e);
        return "formNewEleve";
    }

    @GetMapping("/updateEleve/{id}")
    public String updateEleve(@PathVariable("id") final int id, Model model) {
        Eleve e = repositoryEleve.getEleve(id);
        model.addAttribute("eleve", e);
        return "formUpdateEleve";
    }

    @GetMapping("/deleteEleve/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        repositoryEleve.deleteEleve(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveEleve")
    public ModelAndView saveEleve(@ModelAttribute Eleve eleve) {
        if(eleve.getIdEleve() != null ) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Eleve current = service.getEleve(eleve.getIdEleve());
        }
        service.saveEleve(eleve);
        return new ModelAndView("redirect:/");
    }

}
