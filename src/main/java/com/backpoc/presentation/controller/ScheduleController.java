package com.backpoc.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backpoc.presentation.dto.ProfessorScheduleDTO;
import com.backpoc.service.implementation.ProfessorScheduleServiceImpl;
import com.backpoc.util.RESTMap;

@RestController
@RequestMapping("/api/menu-principal")
public class ScheduleController {

    private final ProfessorScheduleServiceImpl professorScheduleService;

    public ScheduleController(ProfessorScheduleServiceImpl professorScheduleService) {
        this.professorScheduleService = professorScheduleService;
    }

    @PostMapping("")
    public ResponseEntity<ProfessorScheduleDTO> getProfessorSchedule(@RequestBody RESTMap params) {
        return ResponseEntity.ok(professorScheduleService.getProfessorSchedule(params.getLong("professorId")));
    }

}
