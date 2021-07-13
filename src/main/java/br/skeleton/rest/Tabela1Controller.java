/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.rest;

import br.skeleton.model.Tabela1;
import br.skeleton.service.Tabela1Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
@RestController
public class Tabela1Controller {

    @Autowired
    private Tabela1Service service;

    @GetMapping(value = "/tabela1", produces = "application/json")
    public ResponseEntity<List<Tabela1>> getLogs() {
        Optional<List<Tabela1>> response = service.getTabela1();
        if (response.isPresent()) {
            return new ResponseEntity<List<Tabela1>>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Tabela1>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/tabela1/save", produces = "application/json")
    public ResponseEntity<Tabela1> save() {
        Optional<Tabela1> response = service.save();
        if (response.isPresent()) {
            return new ResponseEntity<Tabela1>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Tabela1>(HttpStatus.NOT_FOUND);
        }
    }
}
