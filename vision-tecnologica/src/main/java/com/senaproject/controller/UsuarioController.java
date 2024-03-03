package com.senaproject.controller;


import com.senaproject.model.Usuario;
import com.senaproject.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.update(usuario, id));
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<?> patch(@RequestBody Usuario usuario, @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.patch(usuario, id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long id){
        usuarioService.delete(id);

    }



}
