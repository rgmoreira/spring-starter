/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.rest;

import br.skeleton.db2.model.Tabela2;
import br.skeleton.service.Tabela2Service;
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
public class Tabela2Controller {

    @Autowired
    private Tabela2Service service;

    @GetMapping(value = "/tabela2", produces = "application/json")
    public ResponseEntity<List<Tabela2>> getLogs() {
        Optional<List<Tabela2>> response = service.getTabela2();
        if (response.isPresent()) {
            return new ResponseEntity<List<Tabela2>>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Tabela2>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/tabela2/save", produces = "application/json")
    public ResponseEntity<Tabela2> save() {
        Optional<Tabela2> response = service.save();
        if (response.isPresent()) {
            return new ResponseEntity<Tabela2>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Tabela2>(HttpStatus.NOT_FOUND);
        }
    }
}
