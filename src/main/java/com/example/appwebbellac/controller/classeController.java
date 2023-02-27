package com.example.appwebbellac.controller;


import com.example.appwebbellac.model.Classe;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.model.Professeur;
import com.example.appwebbellac.repository.ClasseRepository;
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
public class classeController {

    @Autowired
    private ClasseService service;

    @Autowired
    private ProfService profService;



    @GetMapping("/classes")
    public String classe(Model model) {
        Iterable<Classe> listClasse = service.getClasse();
        Iterable<Professeur> listProf = profService.getProf();
        model.addAttribute("classes", listClasse);
        model.addAttribute("profs", listProf);
        return "classe";
    }

    @GetMapping("/createClasse")
    public String createClasse(Model model) {
        Classe c = new Classe();
        model.addAttribute("classe", c);
        return "formNewClasse";
    }

    @GetMapping("/updateClasse/{id}")
    public String updateClasse(@PathVariable("id") final int id, Model model) {
        Classe c = service.getClasse(id);
        model.addAttribute("classe", c);
        return "";
    }

    @GetMapping("/deleteClasse/{id}")
    public ModelAndView deleteClasse(@PathVariable("id") final int id) {
        service.deleteClasse(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveClasse")
    public ModelAndView saveClasse(@ModelAttribute Classe classe) {
        if(classe.getIdCLasse() != null ) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Classe current = service.getClasse(classe.getIdCLasse());
        }
        service.saveClasse(classe);
        return new ModelAndView("redirect:/");
    }
}
