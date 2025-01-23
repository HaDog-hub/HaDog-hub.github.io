package com.backend.project.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, String>{
    Optional<Staff> findByUsername(String username);
}
