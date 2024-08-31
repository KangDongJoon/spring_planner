package com.sparta.planner.repository;

import com.sparta.planner.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
