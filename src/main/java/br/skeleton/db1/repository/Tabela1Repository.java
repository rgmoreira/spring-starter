/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.skeleton.db1.repository;

import br.skeleton.db1.model.Tabela1;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
public interface Tabela1Repository extends JpaRepository<Tabela1, Long> {

    List<Tabela1> findAll();
}
