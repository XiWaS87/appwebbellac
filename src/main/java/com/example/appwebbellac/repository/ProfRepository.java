package com.example.appwebbellac.repository;


import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Professeur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ProfRepository {
    @Autowired
    private CustomProperties props;


    public Iterable<Professeur> getProf() {
        System.out.println(props.getApiUrl());
        String baseApiUrl = props.getApiUrl();
        String getProfUrl = baseApiUrl + "/profs";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Professeur>> response = restTemplate.exchange(
                getProfUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Professeur>>() {}
        );
        log.debug("Get professeur call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Professeur getProf(int id) {
        String baseApiUrl = props.getApiUrl();
        String getProfUrl = baseApiUrl + "/prof/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Professeur> response = restTemplate.exchange(
                getProfUrl,
                HttpMethod.GET,
                null,
                Professeur.class
        );

        log.debug("Get professeur call " + response.getStatusCode().toString());
        return response.getBody();
    }


    public Professeur createProf(Professeur p) {
        String baseApiUrl = props.getApiUrl();
        String createProfUrl = baseApiUrl + "/addProf";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Professeur> request = new HttpEntity<Professeur>(p);
        ResponseEntity<Professeur> response = restTemplate.exchange(
                createProfUrl,
                HttpMethod.POST,
                request,
                Professeur.class);

        log.debug("Get professeur call " + response.getStatusCode().toString());
        return response.getBody();
    }


    public Professeur updateProf(Professeur p) {
        String baseApiUrl = props.getApiUrl();
        String updateProfUrl = baseApiUrl + "/ModifProf/" + p.getIdProf();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Professeur> request = new HttpEntity<Professeur>(p);
        ResponseEntity<Professeur> response = restTemplate.exchange(
                updateProfUrl,
                HttpMethod.PUT,
                request,
                Professeur.class);

        log.debug("Get professeur call " + response.getStatusCode().toString());
        return response.getBody();
    }


    public void deleteProf(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteProfUrl = baseApiUrl + "/delProf/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteProfUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Get professeur call " + response.getStatusCode().toString());
    }

}
