package com.sparta.planner.dto;

import com.sparta.planner.entity.Comment;
import com.sparta.planner.entity.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public PlanResponseDto(Plan plan, List<Comment> comments) {
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponseDtoList.add(new CommentResponseDto(comment));
        }
        this.id = plan.getId();
        this.postedBy = plan.getPostedBy();
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.postedAt = plan.getPostedAt();
        this.updatedAt = plan.getUpdatedAt();
        this.comments = commentResponseDtoList;
    }
}
