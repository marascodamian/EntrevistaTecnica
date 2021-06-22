package com.cashonline.marasco.dto;

public class PagingDto {

    private int page;
    private int size;
    private Long total;

    public PagingDto() {
    }

    public PagingDto(int page, int size, Long total) {
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

