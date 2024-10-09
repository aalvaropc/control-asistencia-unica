package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.course.id = :courseId AND s.professor.id = :professorId")
    Schedule findScheduleByCourseAndProfessor(
            @Param("courseId") Long courseId,
            @Param("professorId") Long professorId
    );
}
