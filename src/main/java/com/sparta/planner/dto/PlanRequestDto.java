package com.sparta.planner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlanRequestDto {
//    private String postedBy;
    private Long userId;
    private String title;
    private String content;
}
