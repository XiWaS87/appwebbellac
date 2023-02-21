package com.example.appwebbellac.controller;

import com.example.appwebbellac.model.Diplome;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.repository.ClasseRepository;
import com.example.appwebbellac.repository.DiplomeRepository;
import com.example.appwebbellac.service.ClasseService;
import com.example.appwebbellac.service.DiplomeService;
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
public class diplomeController {


    @Autowired
    private DiplomeService service;


    @GetMapping("/diplomes")
    public String diplome(Model model) {
        Iterable<Diplome> listDiplome = service.getDiplome();
        model.addAttribute("diplomes", listDiplome);
        return "diplome";
    }

    @GetMapping("/diplomesModifSuppr")
    public String diplomeModifSuppr(Model model) {
        Iterable<Diplome> listDiplome = service.getDiplome();
        model.addAttribute("diplomes", listDiplome);
        return "modifsupprDiplome";
    }

    @GetMapping("/createDiplome")
    public String createDiplome(Model model) {
        Diplome d = new Diplome();
        model.addAttribute("diplome", d);
        return "formNewDiplome";
    }

    @GetMapping("/updateDiplome/{id}")
    public String updateDiplome(@PathVariable("id") final int id, Model model) {
        Diplome d = service.getDiplome(id);
        model.addAttribute("diplome", d);
        return "updateDiplome";
    }

    @GetMapping("/deleteDiplome/{id}")
    public ModelAndView deleteDiplome(@PathVariable("id") final int id) {
        service.deleteDiplome(id);
        return new ModelAndView("redirect:/diplomesModifSuppr");
    }

    @PostMapping("/saveDiplome")
    public ModelAndView saveDiplome(@ModelAttribute Diplome diplome) {
        service.saveDiplome(diplome);
        return new ModelAndView("redirect:/diplomes");
    }

}
