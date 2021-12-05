package com.cursofullstack.aplicacion.dao;

import com.cursofullstack.aplicacion.auth.AuthUtils;
import com.cursofullstack.aplicacion.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> result = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if( result.isEmpty() ) {
            return null;
        }

        Usuario usuarioEncontrado = result.get(0);
        if( !AuthUtils.verifyHash(usuarioEncontrado.getPassword(),usuario.getPassword()) ){
            return null;
        }

        return usuarioEncontrado;
    }
}
