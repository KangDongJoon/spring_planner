package com.sparta.planner.dto;

import com.sparta.planner.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String commentedBy;
    private LocalDateTime commentedAt;
    private LocalDateTime commentUpdatedAt;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.commentedBy = comment.getCommentedBy();
        this.commentedAt = comment.getCommentedAt();
        this.commentUpdatedAt = comment.getCommentUpdatedAt();
    }
}
