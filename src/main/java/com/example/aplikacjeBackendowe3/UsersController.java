package com.example.aplikacjeBackendowe3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/api/users")
    public ResponseEntity<UsersPage> getUsers(
            @RequestParam(name = "page-number", defaultValue = "1") int pageNumber,
            @RequestParam(name = "page-size", defaultValue = "20") int pageSize
    ){
        return ResponseEntity.ok(this.usersService.getUsers(pageNumber, pageSize));
    }
}
