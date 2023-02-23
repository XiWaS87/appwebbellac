package com.example.appwebbellac.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;



@Data
public class Eleve {
    private Integer idEleve;
    private String adresse;
    private boolean habil_travail_machine;
    private boolean habil_travail_proximite_reseau;
    private boolean habil_electrique;
    private String specialite;
    private Date dateNaissance;


    private String dateCreation_formatted;

    public String getDateCreation_formatted() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(this.dateNaissance);
        return formattedDate;
    }

    public void setDateCreation_formatted(String dateCreation_formatted) {
        this.dateCreation_formatted = dateCreation_formatted;
    }
    private boolean visiteMedical;
    private String nom;
    private String prenom;
    private String numerotel;
    private String mail;

    private Professeur professeur;

    private Tuteur tuteur;

    private Diplome diplome;

    private Classe classe;

    private Acces acces;

}
