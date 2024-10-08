package com.backpoc.presentation.dto;

import java.util.List;
import java.util.Map;

public class ProfessorScheduleDTO {

    private String professorFirstName;
    private String professorLastName;
    private String facultyName;

    public Map<String, List<CourseScheduleDTO>> getDailyCourses() {
        return dailyCourses;
    }

    public void setDailyCourses(Map<String, List<CourseScheduleDTO>> dailyCourses) {
        this.dailyCourses = dailyCourses;
    }

    private Map<String, List<CourseScheduleDTO>> dailyCourses;

    public String getProfessorFirstName() {
        return professorFirstName;
    }

    public void setProfessorFirstName(String professorFirstName) {
        this.professorFirstName = professorFirstName;
    }

    public String getProfessorLastName() {
        return professorLastName;
    }

    public void setProfessorLastName(String professorLastName) {
        this.professorLastName = professorLastName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }



}
