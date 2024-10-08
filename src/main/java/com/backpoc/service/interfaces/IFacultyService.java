package com.backpoc.service.interfaces;

import java.util.List;

import com.backpoc.persistence.entity.User;
import com.backpoc.presentation.dto.FacultyDTO;

public interface IFacultyService {

    FacultyDTO createFaculty(FacultyDTO facultyDTO);

    FacultyDTO getFacultyById(Long id);

    List<FacultyDTO> getAllFaculties();

    FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO);

    void deleteFaculty(Long id);

}
