package com.sparta.planner.dto;

import com.sparta.planner.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PlanResponseDto {
    private Long id;
    private String postedBy;
    private String title;
    private String content;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.postedBy = plan.getPostedBy();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.postedAt = plan.getPostedAt();
        this.updatedAt = plan.getUpdatedAt();
    }
}
