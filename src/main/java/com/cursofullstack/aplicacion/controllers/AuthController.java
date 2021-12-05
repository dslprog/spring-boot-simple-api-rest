package com.cursofullstack.aplicacion.controllers;

import com.cursofullstack.aplicacion.auth.JWTUtil;
import com.cursofullstack.aplicacion.dao.UsuarioDao;
import com.cursofullstack.aplicacion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if( usuarioEncontrado != null ) {
            String token = jwtUtil.create(String.valueOf(usuarioEncontrado.getId()), usuarioEncontrado.getEmail());
            return token;
        }
        return "KO";
    }
}
