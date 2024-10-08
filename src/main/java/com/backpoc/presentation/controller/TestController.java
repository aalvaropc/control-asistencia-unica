package com.backpoc.presentation.controller;

import com.backpoc.presentation.dto.AttendancyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ ")
public class TestController{


    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }

}
