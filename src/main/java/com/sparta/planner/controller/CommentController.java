package com.sparta.planner.controller;

import com.sparta.planner.dto.CommentRequestDto;
import com.sparta.planner.dto.CommentResponseDto;
import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.service.CommentService;
import com.sparta.planner.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plans/{planId}/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public CommentResponseDto postComment(@PathVariable Long planId, @RequestBody CommentRequestDto requestDto){
        return commentService.postComment(planId, requestDto);
    }

    // 댓글 전체 조회
    @GetMapping
    public List<CommentResponseDto> searchAllComment(@PathVariable Long planId){
        return commentService.searchAllComment(planId);
    }

    // 댓글 단건 조회
    @GetMapping("/{commentId}")
    public CommentResponseDto searchComment(@PathVariable Long planId, @PathVariable Long commentId){
        return commentService.searchComment(planId, commentId);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long planId, @PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        return commentService.updateComment(planId, commentId, requestDto);
    }

    // 댓글 삭제
    @DeleteMapping("{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long planId, @PathVariable Long commentId){
        return commentService.deleteComment(planId, commentId);
    }
}
