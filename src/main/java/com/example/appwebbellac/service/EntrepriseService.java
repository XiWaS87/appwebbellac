package com.example.appwebbellac.service;


import com.example.appwebbellac.model.Diplome;
import com.example.appwebbellac.model.Entreprise;
import com.example.appwebbellac.repository.EntrepriseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Entreprise getEntreprise(final int id) {
        return entrepriseRepository.getEntreprise(id);
    }

    public Iterable<Entreprise> getEntreprise() {
        return entrepriseRepository.getEntreprise();
    }

    public void deleteEntreprise(final int id) {
        entrepriseRepository.deleteEntreprise(id);
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        Entreprise savedEntreprise;

        // Functional rule : Last name must be capitalized.
        entreprise.setNomEnt(entreprise.getNomEnt());

        if(entreprise.getIdEnt() == null) {
            // If id is null, then it is a new employee.
            savedEntreprise = entrepriseRepository.createEntreprise(entreprise);
        } else {
            savedEntreprise = entrepriseRepository.updateEntreprise(entreprise);
        }

        return savedEntreprise;
    }
}
