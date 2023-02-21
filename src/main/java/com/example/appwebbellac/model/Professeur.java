package com.example.appwebbellac.model;

import lombok.Data;

import java.util.List;

@Data
public class Professeur {
    private Integer idProf;

    private String NOM;

    private String PRENOM;

    private String NUMEROTEL;

    private String MAIL;
    private Acces acces;

    private Classe classe;
}
