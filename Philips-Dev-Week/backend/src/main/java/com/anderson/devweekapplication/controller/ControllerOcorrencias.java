package com.anderson.devweekapplication.controller;

import com.anderson.devweekapplication.entity.OcorenciaExame;
import com.anderson.devweekapplication.repository.OcorrenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerOcorrencias {

    private final OcorrenciaRepo inRepository;

    public ControllerOcorrencias(OcorrenciaRepo ocRepository) {
        this.inRepository = ocRepository;
    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<List<OcorenciaExame>> findOcorrecnia(){
        List<OcorenciaExame> listaOcorrencia = inRepository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/ocorrencias/{id}")
    public ResponseEntity<OcorenciaExame> findOcorrenciaById(@PathVariable Long id){
        Optional<OcorenciaExame> ocorrenciaOptional = inRepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            OcorenciaExame ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/ocorrencias/novo")
    public OcorenciaExame newOcorrencia(@RequestBody OcorenciaExame newOcorrencia) {
        return inRepository.save(newOcorrencia);
    }
}
