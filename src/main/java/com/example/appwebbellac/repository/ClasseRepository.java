package com.example.appwebbellac.repository;


import com.example.appwebbellac.CustomProperties;
import com.example.appwebbellac.model.Classe;
import com.example.appwebbellac.model.Eleve;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ClasseRepository {
    @Autowired
    private CustomProperties props;


    public Iterable<Classe> getClasse() {

        String baseApiUrl = props.getApiUrl();
        String getClasseUrl = baseApiUrl + "/classes";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Classe>> response = restTemplate.exchange(
                getClasseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Classe>>() {}
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Classe getClasse(int id) {
        String baseApiUrl = props.getApiUrl();
        String getClasseUrl = baseApiUrl + "/classes/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Classe> response = restTemplate.exchange(
                getClasseUrl,
                HttpMethod.GET,
                null,
                Classe.class
        );


        return response.getBody();
    }


    public Classe createClasse(Classe c) {
        String baseApiUrl = props.getApiUrl();
        String createClasseUrl = baseApiUrl + "/classes";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Classe> request = new HttpEntity<Classe>(c);
        ResponseEntity<Classe> response = restTemplate.exchange(
                createClasseUrl,
                HttpMethod.POST,
                request,
                Classe.class);


        return response.getBody();
    }


    public Classe updateClasse(Classe c) {
        String baseApiUrl = props.getApiUrl();
        String updateClasseUrl = baseApiUrl + "/classes/" + c.getIdCLasse();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Classe> request = new HttpEntity<Classe>(c);
        ResponseEntity<Classe> response = restTemplate.exchange(
                updateClasseUrl,
                HttpMethod.PUT,
                request,
                Classe.class);

        return response.getBody();
    }


    public void deleteClasse(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteClasseUrl = baseApiUrl + "/classes/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteClasseUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete eleves call " + response.getStatusCode().toString());
    }
}
