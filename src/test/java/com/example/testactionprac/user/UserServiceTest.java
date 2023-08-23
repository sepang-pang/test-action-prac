package com.example.testactionprac.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired UserService userService;

    @Test
    @DisplayName("회원가입 정상적")
    public void UserService_join_success() {
        //given
        User user = new User("user");

        //when
        Long id = userService.join(user);

        //then
        Assertions.assertThat(id).isGreaterThan(0);
    }

    @Test
    @DisplayName("회원가입 사용자명 공백 실패")
    public void UserService_join_emptyUsername() {
        //given
        User user = new User("");

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> userService.join(user));

        //then
        Assertions.assertThat(e.getMessage()).isEqualTo("유효한 회원명이 아닙니다.");
    }

    @Test
    @DisplayName("회원가입 사용자명 공백 실패")
    public void UserService_join_duplicateUsername() {
        //given
        User user = new User("user");

        //when
        userService.join(user);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> userService.join(user));

        //then
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}