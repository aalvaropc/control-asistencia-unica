package com.backpoc.service.interfaces;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.presentation.dto.AttendancyDTO;
import com.backpoc.presentation.dto.AttendancyRegisterDTO;

public interface IAttendancyService {

    String createAttendancy(AttendancyRegisterDTO attendancyRegisterDTO);


    AttendancyDTO getAttendancyById(Long id);

    List<AttendancyDTO> getAllAttendancies();

    AttendancyDTO updateAttendancy(Long id, AttendancyDTO attendancyDTO);

    void deleteAttendancy(Long id);

    List<AttendancyDTO> filterAttendances(Long professorId);
}
