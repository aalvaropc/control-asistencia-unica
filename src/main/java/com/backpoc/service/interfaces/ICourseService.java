package com.backpoc.service.interfaces;

import java.util.List;

import com.backpoc.presentation.dto.CourseDTO;

public interface ICourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO getCourseById(Long id);

    List<CourseDTO> getAllCourses();

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);

}
