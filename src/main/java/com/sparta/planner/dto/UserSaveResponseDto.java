package com.sparta.planner.dto;

import com.sparta.planner.entity.User;
import lombok.Getter;

@Getter
public class UserSaveResponseDto {

    private final Long id;
    private final String userName;
    private final String email;

    public UserSaveResponseDto(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();

    }
}
