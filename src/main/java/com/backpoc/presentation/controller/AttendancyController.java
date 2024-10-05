package com.backpoc.presentation.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.util.RESTMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backpoc.presentation.dto.AttendancyDTO;
import com.backpoc.service.interfaces.IAttendancyService;

@RestController
@RequestMapping("/api/attendecies")
public class AttendancyController {

    private final IAttendancyService attendancyService;

    public AttendancyController(IAttendancyService attendancyService) {
        this.attendancyService = attendancyService;
    }


    @PostMapping("/filter")
    public List<AttendancyDTO> filterAttendances(@RequestBody RESTMap params) {
        Long professorId = params.getLong("professorId");
        Long courseId = params.getLong("courseId");
        Date startDate = params.getDate("startDate");
        Date endDate = params.getDate("endDate");

        LocalDateTime startDateTime = startDate != null ? startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
        LocalDateTime endDateTime = endDate != null ? endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;

        return attendancyService.filterAttendances(professorId, courseId, startDateTime, endDateTime);
    }

    @GetMapping
    public ResponseEntity<List<AttendancyDTO>> getAllAttendecies() {
        return ResponseEntity.ok(attendancyService.getAllAttendancies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendancyDTO> getAttendancyById(@PathVariable Long id) {
        return ResponseEntity.ok(attendancyService.getAttendancyById(id));
    }

    @PostMapping
    public ResponseEntity<AttendancyDTO> createAttendancy(@RequestBody AttendancyDTO AttendancyDTO) {
        return ResponseEntity.ok(attendancyService.createAttendancy(AttendancyDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendancyDTO> updateAttendancy(@PathVariable Long id, @RequestBody AttendancyDTO AttendancyDTO) {
        return ResponseEntity.ok(attendancyService.updateAttendancy(id, AttendancyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendancy(@PathVariable Long id) {
        attendancyService.deleteAttendancy(id);
        return ResponseEntity.noContent().build();
    }
}
