package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByEmail(String email);
}
