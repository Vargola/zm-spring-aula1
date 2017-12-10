/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.config;

import com.zm.spring.aula1.entity.Perfil;
import com.zm.spring.aula1.entity.Usuario;
import com.zm.spring.aula1.repository.PerfilRepository;
import com.zm.spring.aula1.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vargola
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        List<Perfil> perfis = perfilRepository.findAll();

        if (perfis.isEmpty()) {
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            perfilRepository.save(new Perfil("ROLE_OREIA"));

            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
            List<Perfil> novosPerfis = new ArrayList<>();
            novosPerfis.add(perfil);
            usuarioRepository.save(new Usuario("ADMIN", "admin", "123", novosPerfis));
        }
    }
}
