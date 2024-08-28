package com.sparta.planner.entity;

import com.sparta.planner.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name ="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String commentedBy;
    @Column(nullable = false)
    private LocalDateTime commentedAt;
    private LocalDateTime commentUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    public Comment(Plan plan, CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
        this.commentedBy = requestDto.getCommentedBy();
        this.commentedAt = LocalDateTime.now();
        this.commentUpdatedAt = LocalDateTime.now();
        this.plan = plan;
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
        this.commentUpdatedAt = LocalDateTime.now();
    }
}
