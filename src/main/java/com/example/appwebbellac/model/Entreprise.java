package com.example.appwebbellac.model;

import lombok.Data;

@Data
public class Entreprise {

    private Integer IdEnt;


    private String nomEnt;
    private String adresseEnt;
    private String telEnt;
    private String mailEnt;
    private String responsableEnt;

    private String numeroImmatriculationEnt;
    private String nomAssuranceEnt;

    private String numeroAssuranceEnt;
}
