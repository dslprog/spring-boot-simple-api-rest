/*
package com.cursofullstack.aplicacion;

import models.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import repository.IUsuarioJpaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioJpaRepositoryTest {
    private IUsuarioJpaRepository repository;

//    @Test
    public void shouldSaveUsuario(){
        Usuario john = new Usuario("John","Smith","jsmith@gmail.com","971123123");
        Usuario claire = new Usuario("Claire","Johnson","jjohnson@gmail.com","971123124");

        repository.save(john);
        repository.save(claire);

        repository.flush();

        assertEquals(2, repository.findAll().size());
    }
}
*/
