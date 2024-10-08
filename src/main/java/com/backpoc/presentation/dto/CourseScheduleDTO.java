package com.backpoc.presentation.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CourseScheduleDTO {

    private Long courseId;
    private String courseName;
    private LocalTime startDateTime;
    private LocalTime endDateTime;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}
