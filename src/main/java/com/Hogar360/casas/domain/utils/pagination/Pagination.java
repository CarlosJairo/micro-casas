package com.Hogar360.casas.domain.utils.pagination;

import java.util.List;

public class Pagination<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int size;
    private int number;

    public Pagination(List<T> content, long totalElements, int totalPages, int size, int number) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.size = size;
        this.number = number;
    }

    public List<T> getContent() {
        return content;
    }


    public long getTotalElements() {
        return totalElements;
    }


    public int getTotalPages() {
        return totalPages;
    }


    public int getSize() {
        return size;
    }


    public int getNumber() {
        return number;
    }

}