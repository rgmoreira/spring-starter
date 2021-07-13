/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.db2.repository;

import br.skeleton.db2.model.Tabela2;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
public interface Tabela2Repository extends JpaRepository<Tabela2, Long> {

    List<Tabela2> findAll();
}
