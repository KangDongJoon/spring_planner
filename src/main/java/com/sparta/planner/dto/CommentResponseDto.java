package com.sparta.planner.dto;

import com.sparta.planner.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String comment;
    private final String commentedBy;
    private final LocalDateTime commentedAt;
    private final LocalDateTime commentUpdatedAt;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.commentedBy = comment.getCommentedBy();
        this.commentedAt = comment.getCommentedAt();
        this.commentUpdatedAt = comment.getCommentUpdatedAt();
    }
}
