package com.project.ranking.domain.util;

public class PaginationUtil {

    private int pageSize;
    private int pageNumber;
    private String filter;
    private boolean ascending;

    public PaginationUtil(int pageSize, int pageNumber, String filter, boolean ascending) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.filter = filter;
        this.ascending = ascending;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
