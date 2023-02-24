package com.example.appwebbellac.repository;

import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Acces;
import com.example.appwebbellac.model.Classe;
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
public class AccesRepository {

    @Autowired
    private CustomProperties props;


    public Acces getLastAcces() {

        String baseApiUrl = props.getApiUrl();
        String getAccesUrl = baseApiUrl + "/LastAcces";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Acces> response = restTemplate.exchange(
                getAccesUrl,
                HttpMethod.GET,
                null,
                Acces.class

        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Acces getAcces(int id) {
        String baseApiUrl = props.getApiUrl();
        String getAccesUrl = baseApiUrl + "/acces/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Acces> response = restTemplate.exchange(
                getAccesUrl,
                HttpMethod.GET,
                null,
                Acces.class
        );


        return response.getBody();
    }


    public Acces createAcces(Acces a) {
        String baseApiUrl = props.getApiUrl();
        String createAccesUrl = baseApiUrl + "/addAcces";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Acces> request = new HttpEntity<Acces>(a);
        ResponseEntity<Acces> response = restTemplate.exchange(
                createAccesUrl,
                HttpMethod.POST,
                request,
                Acces.class);


        return response.getBody();
    }


    public Acces updateAcces(Acces a) {
        String baseApiUrl = props.getApiUrl();
        String updateAccesUrl = baseApiUrl + "/modifAcces/" + a.getIdAcces();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Acces> request = new HttpEntity<Acces>(a);
        ResponseEntity<Acces> response = restTemplate.exchange(
                updateAccesUrl,
                HttpMethod.PUT,
                request,
                Acces.class);

        return response.getBody();
    }


    public void deleteAcces(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteAccesUrl = baseApiUrl + "/delAcces/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteAccesUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete eleves call " + response.getStatusCode().toString());
    }
}
