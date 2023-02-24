package com.example.appwebbellac.model;

import lombok.Data;

@Data
public class Tuteur {
    private long idTuteur;

    private String NOM;

    private String PRENOM;

    private String NUMEROTEL;

    private String MAIL;
    private Entreprise entreprise;
    private Acces accesT;
}
