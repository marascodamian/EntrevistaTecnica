package com.cashonline.marasco.service;

import com.cashonline.marasco.dto.LoanDto;
import com.cashonline.marasco.dto.PaginadoDto;
import com.cashonline.marasco.mapper.LoanMapper;
import com.cashonline.marasco.model.Loan;
import com.cashonline.marasco.repository.LoanRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceImplTest {

    @Autowired
    LoanRepository loanRepositoryMock = Mockito.mock(LoanRepository.class);

    @Autowired
    LoanMapper loanMapper;

    @Autowired
    LoanServiceImpl loanService = new LoanServiceImpl(loanRepositoryMock,loanMapper);

    @BeforeEach
    void setUp() {
        List<Loan>loansMock = new ArrayList<>();

        Mockito.when(loanRepositoryMock.findAll()).thenReturn(loansMock);
    }

    @Test
    void getAllLoans() throws Exception {
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        Page<Loan> loans = loanService.getAllLoans(pageable);

        Assertions.assertEquals(null, loans);

    }

    /*@Test
    void getAllLoansDto() throws Exception {
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        List<LoanDto> paginadoDtoEsperado = new ArrayList<>();
        List<LoanDto> paginadoDtoList = loanService.getAllLoansDto(pageable);

        Assertions.assertEquals(paginadoDtoEsperado,paginadoDtoList);

    }*/

    @Test
    void getAllLoansByUsuario() {
    }

    @Test
    void getAllLoansByUsuarioDto() {
    }
}