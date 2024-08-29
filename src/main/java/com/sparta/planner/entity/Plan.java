package com.sparta.planner.entity;

import com.sparta.planner.dto.PlanRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name ="plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String postedBy;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Plan(PlanRequestDto requestDto) {
        this.postedBy = requestDto.getPostedBy();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.postedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(PlanRequestDto requestDto) {
        if(requestDto.getTitle() != null){
            this.title = requestDto.getTitle();
        }
        if(requestDto.getContent() != null){
            this.content = requestDto.getContent();
        }
        this.updatedAt = LocalDateTime.now();
    }
}
