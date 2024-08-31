package com.sparta.planner.dto;

import com.sparta.planner.entity.Manager;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.entity.User;
import lombok.Getter;

@Getter
public class ManagerSaveResponseDto {
    private final Long id;
    private final UserResponseDto userDto;
    private final PlanResponseDto planDto;

    public ManagerSaveResponseDto(Manager manager){
        this.id = manager.getId();
        this.userDto = new UserResponseDto(manager.getUser());
        this.planDto = new PlanResponseDto(manager.getPlan(), manager.getPlan().getComments());
    }
}
