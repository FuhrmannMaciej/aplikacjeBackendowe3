package com.example.aplikacjeBackendowe3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {

    List<UsersEntity> users = new ArrayList<>();

    public UsersService() {
        users.add(new UsersEntity(1, "adam"));
        users.add(new UsersEntity(2, "john"));
        users.add(new UsersEntity(3, "jake"));
        users.add(new UsersEntity(4, "mia"));
    }

    public UsersPage getUsers (int pageNumber, int pageSize){

        int totalCount = users.size();
        int pageCount = calculatePagesCount(pageSize, totalCount);

        return new UsersPage(pageNumber, pageCount, pageSize, totalCount, users);
    }

    public UsersEntity addUser (UsersEntity user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public int calculatePagesCount(int pageSize, int totalCount) {

        return totalCount < pageSize ? 1 : (int) Math.ceil((double) totalCount / (double) pageSize);
    }

    public UsersEntity getUser(int id) {
        return users.get(id - 1);
    }

    public Map<String, Boolean> deleteUser(int id) {
        users.remove(id - 1);
        return Collections.singletonMap("result", true);
    }

    public UsersEntity updateUser(int id, UsersEntity user) {
        user.setId(id);
        users.set(id - 1, user);
        return user;
    }
}
