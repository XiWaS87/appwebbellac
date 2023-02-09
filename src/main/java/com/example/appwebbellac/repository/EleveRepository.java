package com.example.appwebbellac.repository;

import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Eleve;
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
public class EleveRepository {

    @Autowired
    private CustomProperties props;


    public Iterable<Eleve> getEleve() {

        String baseApiUrl = props.getApiUrl();
        String getEleveUrl = baseApiUrl + "/eleves";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Eleve>> response = restTemplate.exchange(
                getEleveUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Eleve>>() {}
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Eleve getEleve(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEleveUrl = baseApiUrl + "/eleve/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Eleve> response = restTemplate.exchange(
                getEleveUrl,
                HttpMethod.GET,
                null,
                Eleve.class
        );

        log.debug("Get eleves call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new employee
     * @param e A new employee (without an id)
     * @return The employee full filled (with an id)
     */
    public Eleve createEleve(Eleve e) {
        String baseApiUrl = props.getApiUrl();
        String createEleveUrl = baseApiUrl + "/eleve";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Eleve> request = new HttpEntity<Eleve>(e);
        ResponseEntity<Eleve> response = restTemplate.exchange(
                createEleveUrl,
                HttpMethod.POST,
                request,
                Eleve.class);

        log.debug("Create eleves call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update an employee - using the PUT HTTP Method.
     * @param e Existing employee to update
     */
    public Eleve updateEleve(Eleve e) {
        String baseApiUrl = props.getApiUrl();
        String updateEleveUrl = baseApiUrl + "/eleve/" + e.getIdEleve();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Eleve> request = new HttpEntity<Eleve>(e);
        ResponseEntity<Eleve> response = restTemplate.exchange(
                updateEleveUrl,
                HttpMethod.PUT,
                request,
                Eleve.class);

        log.debug("Update eleves call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteEleve(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEleveUrl = baseApiUrl + "/eleves/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEleveUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete eleves call " + response.getStatusCode().toString());
    }



}
