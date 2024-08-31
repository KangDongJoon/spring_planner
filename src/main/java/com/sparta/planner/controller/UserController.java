package com.sparta.planner.controller;

import com.sparta.planner.dto.UserRequestDto;
import com.sparta.planner.dto.UserResponseDto;
import com.sparta.planner.dto.UserSaveResponseDto;
import com.sparta.planner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserSaveResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    @GetMapping
    public Page<UserResponseDto> searchAllUser(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return userService.searchAllUser(page, size);
    }

    @GetMapping("{id}")
    public UserResponseDto searchUser(@PathVariable Long id){
        return userService.searchUser(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


}
