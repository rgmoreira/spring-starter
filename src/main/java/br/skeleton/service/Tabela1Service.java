/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.service;

import br.skeleton.model.Tabela1;
import br.skeleton.repository.Tabela1Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
@Service
public class Tabela1Service {

    @Autowired
    private Tabela1Repository repository;

    public Optional<List<Tabela1>> getTabela1() {
        return Optional.ofNullable(repository.findAll());
    }

    public Optional<Tabela1> save() {
        return Optional.ofNullable(repository.save(new Tabela1()));
    }

}
