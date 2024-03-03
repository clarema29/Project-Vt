package com.senaproject.service;

import com.senaproject.model.Usuario;
import com.senaproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El id no existe"));
    }

    @Override
    public Usuario save(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario, Long id) {
        Usuario usuarioNew = usuarioRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(("El usuario no fue encontrado")));
        usuarioNew.setNombre(usuario.getNombre());
        usuarioNew.setApellido(usuario.getApellido());
        usuarioNew.setEmail(usuario.getEmail());
        usuarioNew.setPassword(usuario.getPassword());
        usuarioNew.setTelefono(usuario.getTelefono());
        usuarioNew.setDireccion(usuario.getDireccion());
        return usuarioRepository.save(usuarioNew);
    }

    @Override
    public Usuario patch(Usuario usuario, Long id) {
        Usuario usuarioNew = usuarioRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("El usuario no fue encontrado"));
        if(usuario.getNombre() != null){
            usuarioNew.setNombre(usuario.getNombre());
        }
        if (usuario.getApellido() != null){
            usuarioNew.setApellido(usuario.getApellido());
        }
        if (usuario.getEmail() != null){
            usuarioNew.setEmail(usuario.getEmail());
        }
        if (usuario.getPassword() != null){
            usuarioNew.setPassword(usuario.getPassword());
        }
        if (usuario.getTelefono() != null){
            usuarioNew.setTelefono(usuario.getTelefono());
        }
        if (usuario.getDireccion() != null){
            usuarioNew.setDireccion(usuario.getDireccion());
        }

        return usuarioRepository.save(usuarioNew);
    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            usuarioRepository.delete(usuario);
        }else{
            throw new IllegalArgumentException("el usuario no existe");
        }


    }
}
