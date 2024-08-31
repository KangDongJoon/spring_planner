package com.sparta.planner.repository;

import com.sparta.planner.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByPlanId(Long planId);
}

