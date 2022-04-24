package com.example.aplikacjeBackendowe3;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersPage {

    private int pageNumber;
    private int pagesCount;
    private int pageSize;
    private int totalCount;

    private Collection<UsersEntity> users;

    public UsersPage() {
    }

    public UsersPage(int pageNumber, int pagesCount, int pageSize, int totalCount, Collection<UsersEntity> users) {
        this.pageNumber = pageNumber;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Collection<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UsersEntity> users) {
        this.users = users;
    }
}
