package com.backpoc.service.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.presentation.dto.AttendancyDTO;

public interface IAttendancyService {

    AttendancyDTO createAttendancy(AttendancyDTO attendancyDTO);

    AttendancyDTO getAttendancyById(Long id);

    List<AttendancyDTO> getAllAttendancies();

    AttendancyDTO updateAttendancy(Long id, AttendancyDTO attendancyDTO);

    void deleteAttendancy(Long id);

    List<AttendancyDTO> filterAttendances(Long professorId, Long courseId, LocalDateTime startDate, LocalDateTime endDate);
}
