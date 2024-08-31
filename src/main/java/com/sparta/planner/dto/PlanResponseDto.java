package com.sparta.planner.dto;

import com.sparta.planner.entity.Comment;
import com.sparta.planner.entity.Plan;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PlanResponseDto {

    private final Long id;
    //    private final String postedBy;
    private final UserSaveResponseDto userDto;
    private final String title;
    private final String content;
    private final LocalDateTime postedAt;
    private final LocalDateTime updatedAt;
    private final List<CommentResponseDto> comments;

    public PlanResponseDto(Plan plan, List<Comment> comments) {
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponseDtoList.add(new CommentResponseDto(comment));
        }
        this.id = plan.getId();
//        this.postedBy = plan.getPostedBy();
        this.userDto = new UserSaveResponseDto(plan.getUser());
        this.title = plan.getTitle();
        this.content = plan.getContent();
        this.postedAt = plan.getPostedAt();
        this.updatedAt = plan.getUpdatedAt();
        this.comments = commentResponseDtoList;
    }
}
