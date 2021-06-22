package com.cashonline.marasco.service;

import com.cashonline.marasco.model.Usuario;
import com.cashonline.marasco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> getById(long id) {

        return Optional.of(usuarioRepository.getById(id)) ;

    }

    @Override
    public boolean existsById(long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public boolean save(Usuario nuevoUsuario)throws Exception {

        try{

            usuarioRepository.save(nuevoUsuario);
            return true;

        }catch(Exception e){
            throw new Exception(e.getMessage());

        }


    }

    @Override
    public boolean delete(Usuario usuario)throws Exception {
        try{
            usuarioRepository.delete(usuario);
            return true;
        }catch(Exception e){
            throw new Exception(e.getMessage());

        }

    }
}
