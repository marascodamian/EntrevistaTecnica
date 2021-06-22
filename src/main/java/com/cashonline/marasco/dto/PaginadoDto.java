package com.cashonline.marasco.dto;

import com.cashonline.marasco.model.Loan;
import org.springframework.data.domain.Page;

import java.util.List;


public class PaginadoDto {

    private List<LoanDto> items;
    private PagingDto pagins;

    public PaginadoDto() {
    }

    public PaginadoDto(List<LoanDto> items, PagingDto pagins) {
        this.items = items;
        this.pagins = pagins;
    }

    public List<LoanDto> getItems() {
        return items;
    }

    public void setItems(List<LoanDto> items) {
        this.items = items;
    }

    public PagingDto getPagins() {
        return pagins;
    }

    public void setPagins(PagingDto pagins) {
        this.pagins = pagins;
    }
}
