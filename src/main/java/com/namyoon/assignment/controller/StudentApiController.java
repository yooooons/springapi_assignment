package com.namyoon.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.namyoon.assignment.Service.StudentService;
import com.namyoon.assignment.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentApiController {
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity students() {
        try {
            List<StudentDto.Response> result = studentService.searchAll();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/id/{id}")
    public ResponseEntity stuId(@PathVariable Long id) {

        try {
            StudentDto.Response result = studentService.searchId(id);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/name/{name}")
    public ResponseEntity stuName(@PathVariable String name) {
        try {
            List<StudentDto.Response> result = studentService.searchName(name);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new")
    public ResponseEntity saveStu(@ModelAttribute StudentDto.Request request) {
        try {
            StudentDto.Response result = studentService.saveStudent(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStu(@PathVariable Long id) {
        try {
            String result = studentService.deleteStudent(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStu(@PathVariable Long id, @ModelAttribute StudentDto.Request request) {
        try {
            StudentDto.Response result = studentService.updateStudent(id, request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/raise/{id}")
    public ResponseEntity raiseStu(@PathVariable Long id) {
        try {
            String result = studentService.raiseGradeStudent(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
