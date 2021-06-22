package com.cashonline.marasco.dto;


public class LoanDto {

    private Long id;
    private Double total;
    private Long idUsuario;

    public LoanDto() {

    }

    public LoanDto(Long id, Double total, Long idUsuario) {
        this.id = id;
        this.total = total;
        this.idUsuario = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
