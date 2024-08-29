package com.sparta.planner.dto;

import com.sparta.planner.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PlanResponseDto {

    private Long id;
    private String postedBy;
    private String title;
    private String content;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;
    private List<CommentResponseDto> comments;

    public PlanResponseDto(Plan plan, List<CommentResponseDto> comments) {
        this.id = plan.getId();
        this.postedBy = plan.getPostedBy();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.postedAt = plan.getPostedAt();
        this.updatedAt = plan.getUpdatedAt();
        this.comments = comments;
    }
}
