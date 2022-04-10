package com.example.aplikacjeBackendowe3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    public UsersPage getUsers (int pageNumber, int pageSize){
        List<UsersEntity> users = new ArrayList<>();
        users.add(new UsersEntity(1,"john"));
        users.add(new UsersEntity(2, "jake"));
        users.add(new UsersEntity(3, "mia"));
        int totalCount = users.size();
        int pageCount = calculatePagesCount(pageSize, totalCount);

        return new UsersPage(pageNumber, pageCount, pageSize, totalCount, users);
    }

    public int calculatePagesCount(int pageSize, int totalCount) {

        return totalCount < pageSize ? 1 : (int) Math.ceil((double) totalCount / (double) pageSize);
    }
}
