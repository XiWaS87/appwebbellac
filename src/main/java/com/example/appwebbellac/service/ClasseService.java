package com.example.appwebbellac.service;


import com.example.appwebbellac.model.Classe;
import com.example.appwebbellac.model.Eleve;
import com.example.appwebbellac.repository.ClasseRepository;
import com.example.appwebbellac.repository.EleveRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;


    public Classe getClasse(final int id){
        return classeRepository.getClasse(id);
    }


    public Iterable<Classe> getClasse(){
        return classeRepository.getClasse();
    }


    public void deleteClasse(final int id){
        classeRepository.deleteClasse(id);
    }

    public Classe saveClasse(Classe classe) {
        Classe savedClasse;

        // Functional rule : Last name must be capitalized.
        classe.setNOMCLASSE(classe.getNOMCLASSE().toUpperCase());

        if(classe.getIdClasse() == null) {
            // If id is null, then it is a new employee.
            savedClasse = classeRepository.createClasse(classe);
        } else {
            savedClasse = classeRepository.updateClasse(classe);
        }

        return savedClasse;
    }
}
