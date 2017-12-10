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

    public List<Perfil> listaPerfil() {
        return perfilRepository.findAll();
    }

    public Page<Perfil> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return perfilRepository.findAll(pages);
    }

    public Perfil salvarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void deletePerfil(String id) {
        perfilRepository.delete(id);
    }

    public Perfil getById(String id) {
        return perfilRepository.findOne(id);
    }
}
