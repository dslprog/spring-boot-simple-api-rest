package com.cursofullstack.aplicacion.controllers;

import com.cursofullstack.aplicacion.auth.AuthUtils;
import com.cursofullstack.aplicacion.auth.JWTUtil;
import com.cursofullstack.aplicacion.dao.UsuarioDao;
import com.cursofullstack.aplicacion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {
        usuarioDao.delete(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void create(@RequestBody Usuario usuario, @RequestHeader(value = "Authorization") String token) {
        if (!this.tokenValido(token)) {
            return;
        }
        usuario.setPassword(AuthUtils.createHash(usuario.getPassword()));
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (this.tokenValido(token)) {
            return usuarioDao.getUsuarios();
        }
        return new ArrayList<>();
    }

    private boolean tokenValido(String token) {
        String id = jwtUtil.getKey(token);
        return id != null;
    }
}
