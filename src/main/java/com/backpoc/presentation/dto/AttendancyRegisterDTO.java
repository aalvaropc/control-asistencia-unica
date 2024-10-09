package com.backpoc.presentation.dto;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class AttendancyRegisterDTO {
    private Long courseId;
    private Long professorId;

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    public Long getCourseId() { return courseId; }

    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public Long getProfessorId() { return professorId; }

    public boolean isValid() {
        return this.courseId != null && this.professorId != null;
    }
}
