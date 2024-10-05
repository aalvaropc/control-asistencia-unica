package com.backpoc.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.persistence.repository.AttendancyRepository;
import com.backpoc.presentation.dto.AttendancyDTO;
import com.backpoc.service.interfaces.IAttendancyService;
import com.backpoc.util.mapper.AttendancyMapper;

@Service
public class AttendancyServiceImpl implements IAttendancyService {

    @Autowired
    private AttendancyRepository attendancyRepository;

    @Autowired
    private AttendancyMapper attendancyMapper;

    @Override
    public AttendancyDTO createAttendancy(AttendancyDTO attendancyDTO) {
        Attendancy attendancy = attendancyMapper.toEntity(attendancyDTO);
        Attendancy savedAttendancy = attendancyRepository.save(attendancy);
        return attendancyMapper.toDTO(savedAttendancy);
    }

    @Override
    public AttendancyDTO getAttendancyById(Long id) {
        Attendancy attendancy = attendancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendancy not found"));
        return attendancyMapper.toDTO(attendancy);
    }

    @Override
    public List<AttendancyDTO> getAllAttendancies() {
        return attendancyRepository.findAll().stream()
                .map(attendancyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AttendancyDTO updateAttendancy(Long id, AttendancyDTO attendancyDTO) {
        Attendancy attendancy = attendancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendancy not found"));

        Attendancy updatedAttendancy = attendancyRepository.save(attendancy);
        return attendancyMapper.toDTO(updatedAttendancy);
    }

    @Override
    public void deleteAttendancy(Long id) {
        attendancyRepository.deleteById(id);
    }

    @Override
    public List<AttendancyDTO> filterAttendances(Long professorId, Long courseId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Attendancy> attendancies = attendancyRepository.filterAttendances(professorId, courseId, startDate, endDate);

        return attendancies.stream()
                .map(attendancyMapper::attendancyToDTO)
                .collect(Collectors.toList());
    }
}
