package com.sparta.planner.entity;

import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.repository.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name ="plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false)
//    private String postedBy;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
//    private final List<Manager> managers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Plan(PlanRequestDto requestDto, User user) {
//        this.postedBy = requestDto.getPostedBy();
        this.user = user;
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
