package com.example.appwebbellac.service;


import com.example.appwebbellac.model.Diplome;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.repository.DiplomeRepository;
import com.example.appwebbellac.repository.EleveRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class DiplomeService {

    @Autowired
    private DiplomeRepository diplomeRepository;

    public Diplome getDiplome(final int id) {
        return diplomeRepository.getDiplome(id);
    }

    public Iterable<Diplome> getDiplome() {
        return diplomeRepository.getDiplome();
    }

    public void deleteDiplome(final int id) {
        diplomeRepository.deleteDiplome(id);
    }

    public Diplome saveDiplome(Diplome diplome) {
        Diplome savedDiplome;

        // Functional rule : Last name must be capitalized.
        diplome.setNOM((diplome.getNOM()));

        if(diplome.getIdDiplome() == null) {
            // If id is null, then it is a new employee.
            savedDiplome = diplomeRepository.createDiplome(diplome);
        } else {
            savedDiplome = diplomeRepository.updateDiplome(diplome);
        }

        return savedDiplome;
    }




}
