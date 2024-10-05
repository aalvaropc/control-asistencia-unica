package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.Attendancy;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendancyRepository extends JpaRepository<Attendancy, Long> {

    @Query(value = "SELECT a.id, a.course_id, a.department_id, a.professor_id, a.weekday, a.start_time, a.end_time FROM Attendancy a " +
            "WHERE (:professorId IS NOT NULL AND a.professor_id = :professorId) " +
            "  AND (:courseId IS NULL OR a.course_id = :courseId) " +
            "  AND (:startDate IS NOT NULL AND a.start_time >= :startDate) " +
            "  AND (:endDate IS NOT NULL AND a.end_time <= :endDate)",
            nativeQuery = true)
    List<Attendancy> filterAttendances(
            @Param("professorId") Long professorId,
            @Param("courseId") Long courseId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
