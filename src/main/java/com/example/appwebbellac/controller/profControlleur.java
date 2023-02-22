package com.example.appwebbellac.controller;


import com.example.appwebbellac.model.Classe;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.model.Entreprise;
import com.example.appwebbellac.model.Professeur;
import com.example.appwebbellac.repository.EleveRepository;
import com.example.appwebbellac.repository.ProfRepository;
import com.example.appwebbellac.service.ClasseService;
import com.example.appwebbellac.service.EleveService;
import com.example.appwebbellac.service.ProfService;
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
public class profControlleur {

    @Autowired
    private ClasseService classeService;
    @Autowired
    private ProfService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/profs")
    public String prof(Model model) {
        Iterable<Professeur> listProf = service.getProf();
        model.addAttribute("profs", listProf);
        return "prof";
    }

    @GetMapping("/profModifSuppr")
    public String profModifSuppr(Model model) {
        Iterable<Professeur> listProfesseur = service.getProf();
        model.addAttribute("profs", listProfesseur);
        return "modifsupprProfesseur";
    }

    @GetMapping("/createProf")
    public String createProf(Model model) {
        Professeur p = new Professeur();
        Iterable<Classe> c = classeService.getClasse();
        model.addAttribute("classe", c);
        model.addAttribute("prof", p);
        return "formNewProfesseur";
    }

    @GetMapping("/updateProf/{id}")
    public String updateProf(@PathVariable("id") final int id, Model model) {
        Professeur p = service.getProf(id);
        model.addAttribute("eleve", p);
        return "updateProf";
    }

    @GetMapping("/deleteProf/{id}")
    public ModelAndView deleteProf(@PathVariable("id") final int id) {
        service.deleteProf(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveProf")
    public ModelAndView saveProf(@ModelAttribute Professeur professeur) {
        if(professeur.getIdProf() != null) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Professeur current = service.getProf(professeur.getIdProf());
        }
        service.saveProf(professeur);
        return new ModelAndView("redirect:/");
    }

}
