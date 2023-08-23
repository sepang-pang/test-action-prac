package com.example.testactionprac.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        if(user.getName().isEmpty()) {
            throw new IllegalArgumentException("유효한 회원명이 아닙니다.");
        }

        if(userRepository.findByName(user.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        userRepository.save(user);

        return user.getId();
    }
}
