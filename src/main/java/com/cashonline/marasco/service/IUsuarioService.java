package com.cashonline.marasco.service;

import com.cashonline.marasco.dto.UsuarioDto;
import com.cashonline.marasco.model.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario>getById(long id);
    boolean existsById(long id);
    boolean existsByEmail(String email);
    boolean save(Usuario usuario) throws Exception;
    boolean delete(Usuario usuario) throws Exception;
}
