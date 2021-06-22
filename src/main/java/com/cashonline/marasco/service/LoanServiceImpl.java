package com.cashonline.marasco.service;

import com.cashonline.marasco.dto.LoanDto;
import com.cashonline.marasco.mapper.LoanMapper;
import com.cashonline.marasco.model.Loan;
import com.cashonline.marasco.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoanServiceImpl implements ILoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepositoryMock, LoanMapper loanMapper) {
        this.loanRepository = loanRepositoryMock;
        this.loanMapper = loanMapper;
    }

    @Override
    public Page<Loan> getAllLoans(Pageable pageable)throws Exception{

       try {
           return loanRepository.findAll(pageable);
       }catch (Exception e){
           throw new Exception(e.getMessage());
       }


    }

    @Override
    public List<LoanDto> getAllLoansDto(Pageable pageable)throws Exception {

        try{
            Page<Loan>paginado = loanRepository.findAll(pageable);
            LoanDto loanDto;
            List<LoanDto>paginadoDto = new ArrayList<>();

            for (Loan item:
                    paginado.getContent()) {
                loanDto = loanMapper.toDto(item);
                paginadoDto.add(loanDto);
            }

            return paginadoDto;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }


    @Override
    public List<LoanDto> getAllLoansByUsuarioDto(Long id, Pageable pageable)throws Exception {

        try{
            Page<Loan>paginado = loanRepository.findByUsuario(id,pageable);
            LoanDto loanDto;
            List<LoanDto>paginadoDto = new ArrayList<>();

            for (Loan item:
                    paginado.getContent()) {
                loanDto = loanMapper.toDto(item);
                paginadoDto.add(loanDto);
            }

            return paginadoDto;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
