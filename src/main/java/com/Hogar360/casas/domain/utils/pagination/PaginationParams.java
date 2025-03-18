package com.Hogar360.casas.domain.utils.pagination;


public class PaginationParams {
    private int page;
    private int size;
    private boolean orderAsc;

    public PaginationParams(int page, int size, boolean orderAsc) {
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }
}
