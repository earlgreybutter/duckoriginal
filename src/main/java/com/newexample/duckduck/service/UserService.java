package com.newexample.duckduck.service;

import com.newexample.duckduck.entity.User;

public interface UserService {
    // 가입
    User join(String username, String password);
    // 인증 & 개인정보 조회
    User authentication(String token);
    // 비밀번호 변경
    User updatePassword(String token, String password);
    // 탈퇴
    void withdraw(String token);
}