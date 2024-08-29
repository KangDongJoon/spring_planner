package com.sparta.planner.service;

import com.sparta.planner.dto.CommentRequestDto;
import com.sparta.planner.dto.CommentResponseDto;
import com.sparta.planner.entity.Comment;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.repository.CommentRepository;
import com.sparta.planner.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PlanRepository planRepository;


    public CommentResponseDto postComment(Long planId, CommentRequestDto requestDto) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        // Comment 생성 및 초기화
        Comment comment = new Comment(plan, requestDto);

        // DB 저장
        Comment saveComment = commentRepository.save(comment);

        // Dto 변환 반환
        return new CommentResponseDto(saveComment);
    }

    public List<CommentResponseDto> searchAllComment(Long planId) {
        List<Comment> commentList = commentRepository.findByPlanId(planId);
        List<CommentResponseDto> responseDtoList = new ArrayList<>();

        for (Comment comment : commentList) {
            responseDtoList.add(new CommentResponseDto(comment));
        }
        return responseDtoList;
    }

    public CommentResponseDto searchComment(Long planId, Long commentId) {
        // DB Plan 등록 여부 확인
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        // DB 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        // 댓글이 해당 일정에 속해 있는지 확인
        if (!comment.getPlan().getId().equals(plan.getId())) {
            throw new IllegalArgumentException("해당 댓글은 이 일정에 속해 있지 않습니다.");
        }

        return new CommentResponseDto(comment);
    }


    @Transactional
    public CommentResponseDto updateComment(Long planId, Long commentId, CommentRequestDto requestDto) {
        // DB Plan 등록 여부 확인
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        // DB 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        comment.update(requestDto);

        return new CommentResponseDto(comment);

    }

    public ResponseEntity<String> deleteComment(Long planId, Long commentId) {
        // DB Plan 등록 여부 확인
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        // DB 조회
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);

        return ResponseEntity.ok("댓글이 성공적으로 삭제되었습니다.");
    }
}
