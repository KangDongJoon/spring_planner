package com.sparta.planner.service;

import com.sparta.planner.dto.UserRequestDto;
import com.sparta.planner.dto.UserResponseDto;
import com.sparta.planner.dto.UserSaveResponseDto;
import com.sparta.planner.entity.User;
import com.sparta.planner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSaveResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(requestDto);

        User saveUser = userRepository.save(user);

        return new UserSaveResponseDto(saveUser);
    }

    public Page<UserResponseDto> searchAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<User> users = userRepository.findAllByOrderByModifiedAtDesc(pageable);

        return users.map(UserResponseDto::new);
    }

    public UserResponseDto searchUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return new UserResponseDto(user);
    }

    @Transactional
    public ResponseEntity<String> deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        userRepository.delete(user);
        return ResponseEntity.ok("유저 정보가 정상적으로 삭제됐습니다.");
    }
}

