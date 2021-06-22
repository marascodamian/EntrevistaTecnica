package com.cashonline.marasco.service;

import com.cashonline.marasco.dto.LoanDto;
import com.cashonline.marasco.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILoanService {

    Page<Loan>getAllLoans(Pageable pageable)throws Exception;
    List<LoanDto>getAllLoansDto(Pageable pageable) throws Exception;
    List<LoanDto> getAllLoansByUsuarioDto(Long id, Pageable pageable) throws Exception;
}
