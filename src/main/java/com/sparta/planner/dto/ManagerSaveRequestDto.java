package com.sparta.planner.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManagerSaveRequestDto {
    private Long planUserId; // 작성자
    private Long managerUserId; // 임명할 담당자
}
