package com.cashonline.marasco.controller;

import com.cashonline.marasco.dto.LoanDto;
import com.cashonline.marasco.dto.PaginadoDto;
import com.cashonline.marasco.dto.PagingDto;
import com.cashonline.marasco.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    ILoanService loanService;


    @GetMapping
    public ResponseEntity<?>getLoans(@RequestParam(value ="page") String page,
                                     @RequestParam(value ="size") String size,
                                     @RequestParam(value ="user_id",required = false) String id) throws Exception {

        int pagina = Integer.valueOf(page.toString()) - 1 ;
        int tamaño = Integer.valueOf(size.toString());
        PageRequest pageRequest = PageRequest.of(pagina,tamaño);
        List<LoanDto>items;
        if( id == null){
            items = loanService.getAllLoansDto(pageRequest);
        }else{
            items = loanService.getAllLoansByUsuarioDto(Long.valueOf(id), pageRequest);
        }

        Long totalPaginas = loanService.getAllLoans(pageRequest).getTotalElements();
        PaginadoDto paginadoDto = new PaginadoDto();
        PagingDto paginacion = new PagingDto(Integer.valueOf(page.toString()),tamaño,totalPaginas);
        paginadoDto.setItems(items);
        paginadoDto.setPagins(paginacion);


        return new ResponseEntity<>(paginadoDto, HttpStatus.OK);
    }


}
