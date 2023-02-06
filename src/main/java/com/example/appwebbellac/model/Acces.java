package com.example.appwebbellac.model;

import lombok.Data;

@Data
public class Acces {
    private long idAcces;

    private String IDENTIFIANT;

    private String MDP;

    private String ROLE;
    private Professeur professeur;

    private Tuteur tuteur;
    private Eleve eleve;
}
