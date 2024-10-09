package com.backpoc.presentation.dto;

import com.backpoc.persistence.entity.Schedule;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendancyDTO {
    private Long id;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    private Long scheduleId;
    private String courseName;
    private LocalTime startTime;
    private Boolean isPresent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Boolean present) {
        isPresent = present;
    }




}