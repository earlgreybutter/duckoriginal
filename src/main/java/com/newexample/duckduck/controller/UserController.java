package com.newexample.duckduck.controller;

import com.newexample.duckduck.entity.User;
import com.newexample.duckduck.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    // 사용자 username, password 을 입력받아 새로운 User를 생성하고 그 결과를 반환
    @PostMapping
    public User create(@RequestParam String username, String password) {
        return userService.join(username, password);
    }

    // READ
    // 자신의 정보를 반환 
    @GetMapping(value = "/me")
    public User getMe(@RequestHeader String authorization){
        return userService.authentication(authorization);
    }
    // UPDATE
    // 자신의 비밀번호를 갱신한 뒤 그 결과를 반환
    @PutMapping(value = "/me")
    public User updatePassword(@RequestHeader String authorization, @RequestParam String password) {
        // User user = userRepository.findById(id);
        return userService.updatePassword(authorization, password);
    }
    // DELETE
    // 해당 ID의 사용자를 삭제
    @DeleteMapping
    public void withdraw(@RequestHeader String authorization) {
        userService.withdraw(authorization);
    }
}