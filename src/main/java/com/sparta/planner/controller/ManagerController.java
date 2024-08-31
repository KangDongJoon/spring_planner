package com.sparta.planner.controller;

import com.sparta.planner.dto.ManagerSaveRequestDto;
import com.sparta.planner.dto.ManagerSaveResponseDto;
import com.sparta.planner.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/api/plans/{planId}/manager")
    public ManagerSaveResponseDto saveManager(@PathVariable Long planId, @RequestBody ManagerSaveRequestDto requestDto){
        return managerService.saveManeger(planId, requestDto);
    }

    @GetMapping("/api/plans/{planId}/manager")
    public ManagerSaveResponseDto searchManager(@PathVariable Long planId){
        return managerService.searchManager(planId);
    }

}
