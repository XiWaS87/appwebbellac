package com.example.appwebbellac.repository;


import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Diplome;
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
public class DiplomeRepository {

    @Autowired
    private CustomProperties props;
    public Iterable<Diplome> getDiplome() {

        String baseApiUrl = props.getApiUrl();
        String getDiplomeUrl = baseApiUrl + "/diplome";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Diplome>> response = restTemplate.exchange(
                getDiplomeUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Diplome>>() {}
        );

        log.debug("Get diplome call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Diplome getDiplome(int id) {
        String baseApiUrl = props.getApiUrl();
        String getDiplomeUrl = baseApiUrl + "/diplome/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Diplome> response = restTemplate.exchange(
                getDiplomeUrl,
                HttpMethod.GET,
                null,
                Diplome.class
        );

        log.debug("Get diplome call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new employee
     * @param d A new employee (without an id)
     * @return The employee full filled (with an id)
     */
    public Diplome createDiplome(Diplome d) {
        String baseApiUrl = props.getApiUrl();
        String createDiplomeUrl = baseApiUrl + "/addDiplome";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Diplome> request = new HttpEntity<Diplome>(d);
        ResponseEntity<Diplome> response = restTemplate.exchange(
                createDiplomeUrl,
                HttpMethod.POST,
                request,
                Diplome.class);

        log.debug("Create diplome call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Update an employee - using the PUT HTTP Method.
     * @param d Existing employee to update
     */
    public Diplome updateDiplome(Diplome d) {
        String baseApiUrl = props.getApiUrl();
        String updateDiplomeUrl = baseApiUrl + "/modifDiplome/" + d.getIdDiplome();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Diplome> request = new HttpEntity<Diplome>(d);
        ResponseEntity<Diplome> response = restTemplate.exchange(
                updateDiplomeUrl,
                HttpMethod.PUT,
                request,
                Diplome.class);

        log.debug("Update diplome call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteDiplome(final int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteDiplomeUrl = baseApiUrl + "/delDiplome/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteDiplomeUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete diplome call " + response.getStatusCode().toString());
    }
}
