package com.example.appwebbellac.service;

import com.example.appwebbellac.model.Acces;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.model.Professeur;
import com.example.appwebbellac.repository.EleveRepository;
import com.example.appwebbellac.repository.ProfRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProfService {

    @Autowired
    private ProfRepository profRepository;


    public Professeur getProf(final int id){
        return profRepository.getProf(id);
    }

    public Iterable<Professeur> getProf(){
        return profRepository.getProf();
    }

    public void deleteProf(final int id){
        profRepository.deleteProf(id);
    }


    public Professeur saveProf(Professeur professeur) {
        Professeur savedProf;

        // Functional rule : Last name must be capitalized.
        professeur.setNOM(professeur.getNOM());

        if(professeur.getIdProf() == null) {
            // If id is null, then it is a new employee.
            savedProf = profRepository.createProf(professeur);
        } else {
            savedProf = profRepository.updateProf(professeur);
        }

        return savedProf;
    }
}
