package com.backpoc.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.backpoc.persistence.entity.User;
import com.backpoc.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpoc.persistence.entity.Faculty;
import com.backpoc.persistence.repository.FacultyRepository;
import com.backpoc.presentation.dto.FacultyDTO;
import com.backpoc.service.interfaces.IFacultyService;
import com.backpoc.util.mapper.FacultyMapper;

@Service
public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacultyMapper facultyMapper;

    @Override
    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = facultyMapper.toEntity(facultyDTO);
        Faculty savedFaculty = facultyRepository.save(faculty);
        return facultyMapper.toDTO(savedFaculty);
    }

    @Override
    public FacultyDTO getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        return facultyMapper.toDTO(faculty);
    }

    @Override
    public List<FacultyDTO> getAllFaculties() {
        return facultyRepository.findAll().stream()
                .map(facultyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        Faculty updatedFaculty = facultyRepository.save(faculty);
        return facultyMapper.toDTO(updatedFaculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
