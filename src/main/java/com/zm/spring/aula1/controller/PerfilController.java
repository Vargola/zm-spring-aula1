/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.controller;

import com.zm.spring.aula1.entity.Perfil;
import com.zm.spring.aula1.service.PerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vargola
 */
@RestController
public class PerfilController {
    
    @Autowired
    PerfilService perfilService;
    
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<Perfil> findAll() {
        return this.perfilService.findAll();
    }
    
    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public Perfil save(@RequestBody Perfil perfil) {
        return this.perfilService.save(perfil);
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.PUT)
    public Perfil edit(@RequestBody Perfil perfil) {
        return this.perfilService.save(perfil);
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        this.perfilService.delete(id);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Perfil findOne(@PathVariable String id) {
        return this.perfilService.findOne(id);
    }

    @RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
    public Page<Perfil> findAllPageable(
            @PathVariable int page,
            @PathVariable int size) {
        return this.perfilService.findAllPageable(page, size);
    }
    
    @RequestMapping(value = "/perfil/{nome}/nome", method = RequestMethod.GET)
    public List<Perfil> findByNomeLikeIgnoreCase(@PathVariable String nome) {
        return this.perfilService.findByNomeLikeIgnoreCase(nome);
    }
}
