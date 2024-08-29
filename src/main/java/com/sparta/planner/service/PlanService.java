package com.sparta.planner.service;

import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public PlanResponseDto postPlan(PlanRequestDto requestDto) {
        // Plan 생성 및 초기화
        Plan plan = new Plan(requestDto);

        // DB 저장
        Plan savePlan = planRepository.save(plan);

        // Dto 변환 반환
        return new PlanResponseDto(savePlan);
    }

    public PlanResponseDto searchPlan(Long id) {
        // DB 조회
        Plan plan = planRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
        );

        return new PlanResponseDto(plan);
    }

    @Transactional
    public PlanResponseDto updatePlan(Long id, PlanRequestDto requestDto) {
        // DB 조회
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        plan.update(requestDto);

        return new PlanResponseDto(plan);
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
