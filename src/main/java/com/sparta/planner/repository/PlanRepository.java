package com.sparta.planner.repository;

import com.sparta.planner.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Page<Plan> findAllByOrderByUpdatedAtDesc(Pageable pageable);
}
