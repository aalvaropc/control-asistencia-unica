package com.backpoc.presentation.controller;

import java.time.*;
import java.util.Date;
import java.util.List;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.presentation.dto.AttendancyRegisterDTO;
import com.backpoc.util.GenericResponse;
import com.backpoc.util.RESTMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpoc.presentation.dto.AttendancyDTO;
import com.backpoc.service.interfaces.IAttendancyService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/attendecies")
public class AttendancyController {

    private final IAttendancyService attendancyService;

    public AttendancyController(IAttendancyService attendancyService) {
        this.attendancyService = attendancyService;
    }


    @PostMapping("/listByProfessorId")
    public ResponseEntity<GenericResponse<List<AttendancyDTO>>> filterAttendances(@RequestBody RESTMap params) {
        Long professorId = params.getLong("professorId");
        List<AttendancyDTO> attendances = attendancyService.filterAttendances(professorId);
        if (attendances.isEmpty()) {
            GenericResponse<List<AttendancyDTO>> response = GenericResponse.<List<AttendancyDTO>>builder()
                    .success(false)
                    .message("No attendances found")
                    .data(attendances)
                    .build();
            return ResponseEntity.status(404).body(response);
        }
        GenericResponse<List<AttendancyDTO>> response = GenericResponse.<List<AttendancyDTO>>builder()
                .success(true)
                .message("Attendances successfully list")
                .data(attendances)
                .build();
        return ResponseEntity.status(200).body(response);
    }
    @PostMapping("/create")
    public ResponseEntity<GenericResponse<String>> createAttendancy(@RequestBody AttendancyRegisterDTO attendancyRegisterDTO) {
        String status = attendancyService.createAttendancy(attendancyRegisterDTO);
        if (!status.equals("SUCCESS")){
            GenericResponse<String> response = GenericResponse.<String>builder()
                    .success(false)
                    .message("Attendancy not created")
                    .data(status)
                    .build();
            return ResponseEntity.status(400).body(response);
        }
        GenericResponse<String> response = GenericResponse.<String>builder()
                .success(true)
                .message("Attendancy successfully created")
                .data(status)
                .build();
        return ResponseEntity.status(201).body(response);
    }
    @GetMapping
    public ResponseEntity<List<AttendancyDTO>> getAllAttendecies() {
        return ResponseEntity.ok(attendancyService.getAllAttendancies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendancyDTO> getAttendancyById(@PathVariable Long id) {
        return ResponseEntity.ok(attendancyService.getAttendancyById(id));
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
