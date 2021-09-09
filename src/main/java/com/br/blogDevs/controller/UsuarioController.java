package com.br.blogDevs.controller;

import com.br.blogDevs.entity.Usuario;
import com.br.blogDevs.repository.UsuarioRepository;
import com.br.blogDevs.service.paginaInicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private paginaInicialService paginaInicialService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("{id}")
    public Usuario findById(@PathVariable Integer id){
        return  usuarioRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        usuarioRepository
                .findById(id)
                .map( usuario -> {
                    usuarioRepository.delete(usuario);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void put(@PathVariable Integer id, @RequestBody Usuario usuarioAtt){
        usuarioRepository
                .findById(id)
                .map( usuario -> {
                usuario.setNome(usuarioAtt.getNome());
                usuario.setCargo(usuarioAtt.getCargo());
                usuario.setEmail(usuarioAtt.getEmail());
                usuario.setIdade(usuarioAtt.getIdade());
                usuario.setCpf(usuarioAtt.getCpf());
                return usuarioRepository.save(usuarioAtt);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
