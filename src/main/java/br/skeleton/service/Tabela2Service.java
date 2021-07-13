/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.service;

import br.skeleton.db2.model.Tabela2;
import br.skeleton.db2.repository.Tabela2Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
@Service
public class Tabela2Service {

    @Autowired
    private Tabela2Repository repository;

    public Optional<List<Tabela2>> getTabela2() {
        return Optional.ofNullable(repository.findAll());
    }

    public Optional<Tabela2> save() {
        return Optional.ofNullable(repository.save(new Tabela2()));
    }

}
