/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zm.spring.aula1.repository;

import com.zm.spring.aula1.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Vargola
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    
    List<Usuario> findByNomeLikeIgnoreCase(String name);
    
    Usuario findByEmail(String email);
}
