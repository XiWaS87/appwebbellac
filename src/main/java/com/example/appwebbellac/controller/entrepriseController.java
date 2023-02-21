package com.example.appwebbellac.controller;


import com.example.appwebbellac.model.Diplome;
import com.example.appwebbellac.model.Entreprise;
import com.example.appwebbellac.service.DiplomeService;
import com.example.appwebbellac.service.EntrepriseService;
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
public class entrepriseController {

    @Autowired
    private EntrepriseService service;


    @GetMapping("/entreprises")
    public String entreprise(Model model) {
        Iterable<Entreprise> listEntreprise = service.getEntreprise();
        model.addAttribute("entreprises", listEntreprise);
        return "entreprise";
    }

    @GetMapping("/entreprisesModifSuppr")
    public String entrepriseModifSuppr(Model model) {
        Iterable<Entreprise> listEntreprise = service.getEntreprise();
        model.addAttribute("entreprises", listEntreprise);
        return "modifsupprEntreprise";
    }

    @GetMapping("/createEntreprise")
    public String createEntreprise(Model model) {
        Entreprise e = new Entreprise();
        model.addAttribute("entreprise", e);
        return "formNewEntreprise";
    }

    @GetMapping("/updateEntreprise/{id}")
    public String updateEntreprise(@PathVariable("id") final int id, Model model) {
        Entreprise e = service.getEntreprise(id);
        model.addAttribute("entreprise", e);
        return "updateEntreprise";
    }

    @GetMapping("/deleteEntreprise/{id}")
    public ModelAndView deleteEntreprise(@PathVariable("id") final int id) {
        service.deleteEntreprise(id);
        return new ModelAndView("redirect:/entreprisesModifSuppr");
    }

    @PostMapping("/saveEntreprise")
    public ModelAndView saveEntreprise(@ModelAttribute Entreprise entreprise) {
        service.saveEntreprise(entreprise);
        return new ModelAndView("redirect:/entreprises");
    }
}
