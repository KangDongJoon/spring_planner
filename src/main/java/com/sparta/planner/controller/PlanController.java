package com.sparta.planner.controller;

import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plans")
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public PlanResponseDto postPlan(@RequestBody PlanRequestDto requestDto){
        return planService.postPlan(requestDto);
    }

    @GetMapping("/{id}")
    public PlanResponseDto searchPlan(@PathVariable Long id){
        return planService.searchPlan(id);
    }

    @PutMapping("/{id}")
    public PlanResponseDto updatePlan(@PathVariable Long id, @RequestBody PlanRequestDto requestDto){
        return planService.updatePlan(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id){
        return planService.deletePlan(id);
    }
}
