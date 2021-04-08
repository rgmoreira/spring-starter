/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rgmoreira.springstarter;

import br.com.rgmoreira.springstarter.models.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael
 */
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping("/say")
    public HelloWorld getHello() {
        var hello = new HelloWorld();
        hello.setSay("Hello World!");
        return hello;
    }
}
