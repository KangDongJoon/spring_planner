package com.sparta.planner.service;

import com.sparta.planner.dto.ManagerSaveRequestDto;
import com.sparta.planner.dto.ManagerSaveResponseDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.entity.Manager;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.entity.User;
import com.sparta.planner.repository.ManagerRepository;
import com.sparta.planner.repository.PlanRepository;
import com.sparta.planner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public ManagerSaveResponseDto saveManeger(Long planId, ManagerSaveRequestDto requestDto) {
        // 일정 확인
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );
//        PlanResponseDto planDto

        // 일정 작성자 확인
        if (!plan.getUser().getId().equals(requestDto.getPlanUserId())) {
            throw new IllegalArgumentException("해당 일정 작성자가 아닙니다.");
        }

        // 담당자 정보 확인
        User user = userRepository.findById(requestDto.getManagerUserId())
                .orElseThrow(() -> new IllegalArgumentException("담당자로 임명할 유저가 존재하지 않습니다.")
                );

        Manager manager = new Manager(user, plan);

        // DB 저장
        Manager saveManager = managerRepository.save(manager);

        return new ManagerSaveResponseDto(saveManager);
    }

    public ManagerSaveResponseDto searchManager(Long planId) {
        // 일정 확인
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
                );

        Manager manager = managerRepository.findByPlanId(planId);
        if (manager == null) {
            throw new IllegalArgumentException("해당 일정에 대한 담당자가 존재하지 않습니다.");
        }

        return new ManagerSaveResponseDto(manager);

    }
}
