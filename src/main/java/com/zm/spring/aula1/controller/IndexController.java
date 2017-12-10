/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vargola
 */
@RestController
public class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Endpoint inicial";
    }
}
