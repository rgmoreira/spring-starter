package br.skeleton.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
@RestController
public class IndexController {

    @GetMapping(value = "/", produces = "application/json")
    public String index() {
        return "Hello World";
    }

}
