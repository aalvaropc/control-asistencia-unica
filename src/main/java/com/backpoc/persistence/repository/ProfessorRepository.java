package com.backpoc.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p FROM Professor p JOIN FETCH p.schedules WHERE p.id = :professorId")
    Optional<Professor> findByIdWithSchedules(@Param("professorId") Long professorId);

    Optional<Professor> findById(Long professorId);

}
