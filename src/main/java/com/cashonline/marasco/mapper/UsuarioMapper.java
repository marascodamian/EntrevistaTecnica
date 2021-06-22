package com.cashonline.marasco.mapper;


import com.cashonline.marasco.dto.UsuarioDto;
import com.cashonline.marasco.model.Usuario;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity (UsuarioDto usuarioDto);

    UsuarioDto toDto ( Usuario usuario);

}
