package com.example.aplikacjeBackendowe3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/api/users")
    public ResponseEntity<UsersPage> getUsers(
            @RequestParam(name = "page-number", defaultValue = "1") @Min(1) int pageNumber,
            @RequestParam(name = "page-size", defaultValue = "20") @Min(1) @Max(100) int pageSize
    ){
        return ResponseEntity.ok(this.usersService.getUsers(pageNumber, pageSize));
    }

    @RequestMapping(
            value = "/api/user/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity user){
        return ResponseEntity.ok(this.usersService.addUser(user));
    }

    @RequestMapping(
            value = "/api/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<UsersEntity> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.usersService.getUser(id));
    }

    @RequestMapping(
            value = "/api/users/{id}/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<UsersEntity> updateUser(@PathVariable("id") int id, @RequestBody UsersEntity user){
        return ResponseEntity.ok(this.usersService.updateUser(id, user));
    }

    @RequestMapping(
            value = "/api/users/{id}/remove",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.usersService.deleteUser(id));
    }
}
