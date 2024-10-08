package com.backpoc.presentation.dto;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class AttendancyRegisterDTO {
    private Long courseId;

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}
