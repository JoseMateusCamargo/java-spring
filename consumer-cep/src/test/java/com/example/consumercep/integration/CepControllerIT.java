package com.example.consumercep.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CepControllerIT {

    @Test
    void returnSuccess_whenCepIsRegistered() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        String localidade = "Louveira";
        int louveiraCep = 13290024;
        final String baseUrl = "https://viacep.com.br/ws/" + louveiraCep + "/json/";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        assertThat(result.getBody()).contains(localidade);
    }
}