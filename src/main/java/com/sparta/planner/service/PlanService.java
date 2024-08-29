package com.sparta.planner.service;

import com.sparta.planner.dto.CommentResponseDto;
import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.dto.PlanSaveResponseDto;
import com.sparta.planner.entity.Comment;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public PlanSaveResponseDto postPlan(PlanRequestDto requestDto) {
        // Plan 생성 및 초기화
        Plan plan = new Plan(requestDto);

        // DB 저장
        Plan savePlan = planRepository.save(plan);

        // Dto 변환 반환
        return new PlanSaveResponseDto(savePlan);
    }

    public Page<PlanResponseDto> searchAllPlan(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Plan> plans = planRepository.findAllByOrderByUpdatedAtDesc(pageable);

        return plans.map(plan -> {
            List<Comment> commentList = plan.getComments();
            return new PlanResponseDto(plan, commentList);
        });
//        List<Plan> planList = planRepository.findAll();
//        List<PlanResponseDto>  planResponseDtoList= new ArrayList<>();
//
//        for (Plan plan : planList) {
//            List<Comment> commentList = plan.getComments();
//            List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
//
//            for (Comment comment : commentList) {
//                commentResponseDtoList.add(new CommentResponseDto(comment));
//            }
//            planResponseDtoList.add(new PlanResponseDto(plan, commentResponseDtoList));
//        }
//        return Page<planResponseDto>;
    }

    public PlanResponseDto searchPlan(Long id) {
        // DB 조회
        Plan plan = planRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
        );

        List<Comment> commentList = plan.getComments();

        return new PlanResponseDto(plan, commentList);
    }

    @Transactional
    public PlanResponseDto updatePlan(Long id, PlanRequestDto requestDto) {
        // DB 조회
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        List<Comment> commentList = plan.getComments();

        plan.update(requestDto);

        return new PlanResponseDto(plan, commentList);
    }

    public ResponseEntity<String> deletePlan(Long id) {
        // DB 조회
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        planRepository.delete(plan);

        return ResponseEntity.ok("일정 및 일정에 작성 된 댓글이 성공적으로 삭제되었습니다.");
    }


}
