/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.service;

import com.zm.spring.aula1.entity.Usuario;
import com.zm.spring.aula1.repository.UsuarioRepository;
import java.util.ArrayList;
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
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(String id) {
        usuarioRepository.delete(id);
    }
    
    public Usuario consultarUsuario(String id) {
        return usuarioRepository.findOne(id);
    }
    
    public Page<Usuario> listarUsuarioPaginado(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
    }
    
    public List<Usuario> consultarPeloNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }
}
