package com.example.aplikacjeBackendowe3;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class UsersService {

    List<UsersEntity> users = new ArrayList<>();

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
        if (id > users.size() || users.get(id - 1) == null) {
            return null;
        } else {
        return users.get(id - 1);
        }
    }

    public Map<String, Boolean> deleteUser(int id) {
        if (id > users.size() || users.get(id - 1) == null) {
            return null;
        } else {
        users.set(id - 1, null);
        return Collections.singletonMap("result", true);
        }
    }

    public UsersEntity updateUser(int id, UsersEntity user) {
        if (id > users.size() || users.get(id - 1) == null) {
            return null;
        } else {
            user.setId(id);
            users.set(id - 1, user);
            return user;
        }
    }

    @PostConstruct
    private void onCreate() {
        try(Scanner scanner = new Scanner(new FileReader("src/main/resources/users"))) {
            while (scanner.hasNext()) {
                users.add(new UsersEntity(scanner.nextInt(), scanner.next("[\\w]+")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void onDestroy() {
        try (FileWriter writer = new FileWriter("src/main/resources/users", false)) {
            for (UsersEntity user : users) {
                if (user != null) {
                    writer.write(user.getId() + " " + user.getName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
