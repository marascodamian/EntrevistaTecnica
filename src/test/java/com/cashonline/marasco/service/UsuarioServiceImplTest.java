package com.cashonline.marasco.service;


import com.cashonline.marasco.mapper.UsuarioMapper;
import com.cashonline.marasco.model.Usuario;
import com.cashonline.marasco.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;




public class UsuarioServiceImplTest {


    UsuarioRepository usuarioRepositoryMock = Mockito.mock(UsuarioRepository.class);

    @Autowired
    UsuarioMapper usuarioMapper;

    @Autowired
    UsuarioServiceImpl usuarioService = new UsuarioServiceImpl(usuarioRepositoryMock);

    @BeforeEach
    void setUp() {
        Usuario usuarioMock = new Usuario("marascodamian@gmail.com","Damián","Marasco", null);
        //UsuarioDto usuarioDtoMock = new UsuarioDto("marascodamian@gmail.com","Damián","Marasco");
        Mockito.when(usuarioRepositoryMock.getById(Long.valueOf(1))).thenReturn(usuarioMock);
        Mockito.when(usuarioRepositoryMock.existsById(Long.valueOf(1))).thenReturn(true);
        Mockito.when(usuarioRepositoryMock.existsByEmail("marascodamian@gmail.com")).thenReturn(true);
        Mockito.when(usuarioRepositoryMock.save(usuarioMock)).thenReturn(usuarioMock);
    }

    @Test
    void getById() {
       Optional<Usuario> usuario = usuarioService.getById(1);
        Assertions.assertEquals("marascodamian@gmail.com",usuario.get().getEmail());
        Assertions.assertEquals("Damián",usuario.get().getFirstName());
        Assertions.assertEquals("Marasco",usuario.get().getLastName())  ;

    }

    @Test
    void existsById() {
        boolean exist = usuarioService.existsById(1);
        Assertions.assertEquals(true,exist);
        Assertions.assertTrue(exist);
    }

    @Test
    void existsByEmail() {
        boolean exist = usuarioService.existsByEmail("marascodamian@gmail.com");
        Assertions.assertEquals(true,exist);
        Assertions.assertTrue(exist);
    }

    @Test
    void save() throws Exception {

        Usuario usuario = new Usuario("marascodamian@gmail.com","Damián","Marasco", null);
        Assertions.assertTrue(usuarioService.save(usuario));

    }
    @Test
    void delete() throws Exception {
        Usuario usuario = new Usuario("marascodamian@gmail.com","Damián","Marasco", null);
        Assertions.assertTrue(usuarioService.delete(usuario));

    }


}