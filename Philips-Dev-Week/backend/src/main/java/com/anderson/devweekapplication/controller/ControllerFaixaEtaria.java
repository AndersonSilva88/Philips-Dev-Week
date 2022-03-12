package com.anderson.devweekapplication.controller;

import com.anderson.devweekapplication.entity.FaixaEtaria;
import com.anderson.devweekapplication.repository.FaixaEtariaRepos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {

    private FaixaEtariaRepos fReposity;

    public ControllerFaixaEtaria(FaixaEtariaRepos fReposity) {
        this.fReposity = fReposity;
    }
    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria() {
        try {
            List<FaixaEtaria> lista = fReposity.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByIdFaixaEtaria(@PathVariable long id) {
        try{
            Optional<FaixaEtaria> unidOptional =fReposity.findById(id);
            if (unidOptional.isPresent()) {
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return fReposity.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id) {
        fReposity.deleteById(id);
    }

}
