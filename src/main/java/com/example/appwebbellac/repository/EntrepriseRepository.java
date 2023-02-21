package com.example.appwebbellac.repository;


import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Diplome;
import com.example.appwebbellac.model.Entreprise;
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
public class EntrepriseRepository {

    @Autowired
    private CustomProperties props;
    public Iterable<Entreprise> getEntreprise() {

        String baseApiUrl = props.getApiUrl();
        String getEntrepriseUrl = baseApiUrl + "/entreprises";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Entreprise>> response = restTemplate.exchange(
                getEntrepriseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Entreprise>>() {}
        );

        log.debug("Get Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise getEntreprise(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEntrepriseUrl = baseApiUrl + "/entreprises/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                getEntrepriseUrl,
                HttpMethod.GET,
                null,
                Entreprise.class
        );

        log.debug("Get Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new employee
     * @param d A new employee (without an id)
     * @return The employee full filled (with an id)
     */
    public Entreprise createEntreprise(Entreprise e) {
        String baseApiUrl = props.getApiUrl();
        String createEntrepriseUrl = baseApiUrl + "/AddEntreprise";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(e);
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                createEntrepriseUrl,
                HttpMethod.POST,
                request,
                Entreprise.class);

        log.debug("Create diplome call " + response.getStatusCode().toString());
        return response.getBody();
    }

    /**
     * Update an employee - using the PUT HTTP Method.
     * @param d Existing employee to update
     */
    public Entreprise updateEntreprise(Entreprise e) {
        String baseApiUrl = props.getApiUrl();
        String updateEntrepriseUrl = baseApiUrl + "/modifEntreprise/" + e.getIdEnt();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(e);
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                updateEntrepriseUrl,
                HttpMethod.PUT,
                request,
                Entreprise.class);

        log.debug("Update diplome call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteEntreprise(final int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEntrepriseUrl = baseApiUrl + "/delEntreprise/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEntrepriseUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete diplome call " + response.getStatusCode().toString());
    }
}
