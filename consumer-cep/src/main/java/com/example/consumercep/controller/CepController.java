package com.example.consumercep.controller;

import com.example.consumercep.dto.CepDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cep")
public class CepController {
    @GetMapping("consumer/{cep}")
    public ResponseEntity<CepDto> getAddress(@PathVariable String cep) {
        CepDto cepDto = new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/", CepDto.class).getBody();

        return new ResponseEntity<>(cepDto, HttpStatus.OK);
    }
}