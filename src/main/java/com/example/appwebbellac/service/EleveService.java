package com.example.appwebbellac.service;

import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.repository.EleveRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EleveService {

    @Autowired
    private EleveRepository repositoryEleve;

    public Eleve getEleve(final int id) {
        return repositoryEleve.getEleve(id);
    }

    public Iterable<Eleve> getEleve() {
        return repositoryEleve.getEleve();
    }

    public void deleteEleve(final int id) {
        repositoryEleve.deleteEleve(id);
    }

    public Eleve saveEleve(Eleve eleve) {
        Eleve savedEleve;

        // Functional rule : Last name must be capitalized.
        eleve.setNom(eleve.getNom().toUpperCase());
        if(eleve.getIdEleve() == null) {
            // If id is null, then it is a new employee.
            savedEleve = repositoryEleve.createEleve(eleve);
        } else {
            savedEleve = repositoryEleve.updateEleve(eleve);
        }

        return savedEleve;
    }



}
