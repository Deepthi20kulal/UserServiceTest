package com.example.controller;


import com.example.entity.UserEntityDeepthi;
import com.example.service.UserServiceDeepthi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ControllerDeepthi {


    @Autowired
    private UserServiceDeepthi userService;

    @PostMapping("/add")
    public ResponseEntity<UserEntityDeepthi> addUserDeepthi(@RequestBody UserEntityDeepthi user){
        return ResponseEntity.ok(userService.addUserDeepthi(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityDeepthi> getUserByIdDeepthi(@PathVariable int id){
        UserEntityDeepthi user = userService.getUserByIdDeepthi(id);
        return ResponseEntity.ok(user);
    }


}