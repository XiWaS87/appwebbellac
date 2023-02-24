package com.example.appwebbellac.service;


import com.example.appwebbellac.model.Acces;
import com.example.appwebbellac.repository.AccesRepository;
import com.example.appwebbellac.repository.ClasseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AccesService {

    @Autowired
    private AccesRepository accesRepository;


    public Acces getAcces(final int id){
        return accesRepository.getAcces(id);
    }


    public Acces getLastAcces(){
        return accesRepository.getLastAcces();
    }


    public void deleteAcces(final int id){
        accesRepository.deleteAcces(id);
    }

    public Acces saveAcces(Acces acces) {
        Acces savedAcces;

        // Functional rule : Last name must be capitalized.
        acces.setIDENTIFIANT(acces.getIDENTIFIANT());

        if(acces.getIdAcces() == null) {
            // If id is null, then it is a new employee.
            savedAcces = accesRepository.createAcces(acces);
        } else {
            savedAcces = accesRepository.updateAcces(acces);
        }

        return savedAcces;
    }
}
