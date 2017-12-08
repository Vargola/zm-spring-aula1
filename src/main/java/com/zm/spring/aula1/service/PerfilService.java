/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.service;

import com.zm.spring.aula1.entity.Perfil;
import com.zm.spring.aula1.repository.PerfilRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vargola
 */
@Service
public class PerfilService {
    
    @Autowired
    PerfilRepository perfilRepository;
    
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }
    
    public Page<Perfil> findAllPageable(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return perfilRepository.findAll(pageable);
    }
    
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    public void delete(String id) {
        perfilRepository.delete(id);
    }
    
    public Perfil findOne(String id) {
        return perfilRepository.findOne(id);
    }
    
    public List<Perfil> findByNomeLikeIgnoreCase(String nome) {
        return perfilRepository.findByNomeLikeIgnoreCase(nome);
    }
}
