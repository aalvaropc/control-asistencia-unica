package com.backpoc.service.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.backpoc.persistence.entity.Schedule;
import com.backpoc.persistence.repository.ScheduleRepository;
import com.backpoc.presentation.dto.AttendancyRegisterDTO;
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
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AttendancyMapper attendancyMapper;

    @Override
    public String createAttendancy(AttendancyRegisterDTO attendancyRegisterDTO) {
        if (!attendancyRegisterDTO.isValid()){ return "ERROR"; }
        Schedule schedule = this.scheduleRepository.findScheduleByCourseAndProfessor(attendancyRegisterDTO.getCourseId(), attendancyRegisterDTO.getProfessorId());
        Attendancy atendancy = new Attendancy();
        LocalTime dateAttendancy = LocalTime.now();
        atendancy.setSchedule(schedule);
        atendancy.setStartTime(LocalTime.from(dateAttendancy));
        atendancy.setIsPresent(true);
        attendancyRepository.save(atendancy);
        return "SUCCESS";
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
    public List<AttendancyDTO> filterAttendances(Long professorId) {
        List<Attendancy> attendancy = attendancyRepository.filterAttendances(professorId);
        return attendancy.stream()
                .map(attendancyMapper::toDTO)
                .collect(Collectors.toList());
    }
}
