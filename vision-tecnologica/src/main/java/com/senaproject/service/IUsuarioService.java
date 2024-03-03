package com.senaproject.service;

import com.senaproject.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario, Long id);
    Usuario patch(Usuario usuario, Long id);
    void delete(Long id);

}
