package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.Attendancy;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AttendancyRepository extends JpaRepository<Attendancy, Long> {

    @Query(value = """
        SELECT a.id, a.schedule_id, a.start_time, a.is_present
        FROM attendancy a INNER JOIN schedule s ON a.schedule_id = s.id
        WHERE s.professor_id = :professorId
        """, nativeQuery = true)
    List<Attendancy> filterAttendances(
        @Param("professorId") Long professorId
    );
    @Modifying
    @Transactional
    @Query(value = """
    INSERT INTO attendancy (schedule_id, start_time, is_present)
    VALUES ((SELECT s.id FROM schedule s WHERE s.course_id = :courseId), CURRENT_TIMESTAMP, 1);
    
    """, nativeQuery = true)
    int createAttendancy(
            @Param("courseId") Long courseId
    );
}
