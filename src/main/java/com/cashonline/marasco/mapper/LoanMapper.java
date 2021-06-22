package com.cashonline.marasco.mapper;

import com.cashonline.marasco.dto.LoanDto;
import com.cashonline.marasco.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring", uses = UsuarioMapper.class)
public interface LoanMapper {

    @Mapping(target = "idUsuario", source = "usuario.id")
    LoanDto toDto(Loan loan);

}
