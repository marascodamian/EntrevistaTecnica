package com.cashonline.marasco.controller;


import com.cashonline.marasco.dto.MensajeDto;
import com.cashonline.marasco.dto.UsuarioDto;
import com.cashonline.marasco.mapper.UsuarioMapper;
import com.cashonline.marasco.model.Usuario;
import com.cashonline.marasco.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    UsuarioMapper usuarioMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> user (@Valid @PathVariable long id) throws Exception {
        if(usuarioService.existsById(id)) {

               UsuarioDto usuarioDto = usuarioMapper.toDto(usuarioService.getById(id).get());

               return new ResponseEntity<>(usuarioDto, HttpStatus.OK);

           }else {
               return new ResponseEntity<>(new MensajeDto("Usuario no encontrado"), HttpStatus.BAD_REQUEST);
           }
    }

    @PostMapping
    public ResponseEntity<?> nuevo(@Valid @RequestBody UsuarioDto usuario, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new MensajeDto("Peticion mal realizada"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByEmail(usuario.getEmail())) {
            return new ResponseEntity(new MensajeDto("Email existente"), HttpStatus.BAD_REQUEST);
        }
        usuarioService.save(usuarioMapper.toEntity(usuario));

        return new ResponseEntity(new MensajeDto("Usuario guardado"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@Valid @PathVariable long id) throws Exception {
        if (usuarioService.existsById(id)){
            usuarioService.delete(usuarioService.getById(id).get());
        }else{
            return new ResponseEntity(new MensajeDto("El usuario no existe"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new MensajeDto("Usuario Eliminado"), HttpStatus.OK);
    }


}
