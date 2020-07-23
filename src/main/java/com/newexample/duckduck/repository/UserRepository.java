package com.newexample.duckduck.repository;

import com.newexample.duckduck.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}

/*
 CrudRepository에 뭐가 있는지 가서 보고 써야됨 
*/