package com.newexample.duckduck.controller;

import java.util.Optional;

import com.newexample.duckduck.entity.User;
import com.newexample.duckduck.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manager")
public class ManageUserController {
    private UserRepository userRepository;

    @Autowired
    public ManageUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    // 사용자 name을 입력받아 새로운 User를 생성하고 그 결과를 반환
    @PostMapping
    public User put(@RequestParam String username, String password) {
        return userRepository.save(new User(username, password));
    }

    // READ
    // 모든 사용자 리스트를 반환
    @GetMapping
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    // READ
    // 해당 ID의 사용자를 반환
    @GetMapping(value = "/{id}")
    public Optional<User> findOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    // UPDATE
    // 해당 ID의 사용자 이름을 갱신한 뒤 그 결과를 반환
    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestParam String name) throws Exception {
        // User user = userRepository.findById(id);
        User user;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            user = optional.get();
        }
        else{
            throw new Exception();
        }

        user.setUsername(name);
        return userRepository.save(user);
    }
    // DELETE
    // 해당 ID의 사용자를 삭제
    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userRepository.deleteById(id);
    }
}