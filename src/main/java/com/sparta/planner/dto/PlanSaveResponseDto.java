package com.sparta.planner.dto;

import com.sparta.planner.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PlanSaveResponseDto {
    private final Long id;
//    private String postedBy;
    private final UserSaveResponseDto userDto;
    private final String title;
    private final String content;

    public PlanSaveResponseDto(Plan plan) {
        this.id = plan.getId();
//        this.postedBy = plan.getPostedBy();
        this.userDto = new UserSaveResponseDto(plan.getUser());
        this.title = plan.getTitle();
        this.content = plan.getContent();
    }
}
