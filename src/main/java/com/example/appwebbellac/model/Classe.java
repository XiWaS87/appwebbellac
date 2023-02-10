package com.example.appwebbellac.model;

import lombok.Data;

import java.util.List;
@Data
public class Classe {
    private Integer IdClasse;

    private String NOMCLASSE;
    private List<Eleve> eleves;
    private List<Professeur> profeseurs;

}
