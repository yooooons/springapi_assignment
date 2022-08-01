package com.namyoon.assignment.Service;

import com.namyoon.assignment.dto.StudentDto;
import com.namyoon.assignment.entity.Student;
import com.namyoon.assignment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDto.Response saveStudent(StudentDto.Request studentDto) throws Exception {

        if (studentRepository.validate(studentDto.toEntity())) {
            throw new Exception("<중복입력> 해당 학생이 있습니다.");
        }


        Student student = studentDto.toEntity();
        Student saveStudent = studentRepository.save(student);
        return StudentDto.Response.of(saveStudent);
    }


    public StudentDto.Response searchId(Long id) throws Exception {
        Student findStudent = studentRepository.findById(id);
        return StudentDto.Response.of(findStudent);
    }

    public List<StudentDto.Response> searchAll() throws Exception {
        List<Student> all = studentRepository.findAll();
        return all.stream().map(s -> StudentDto.Response.of(s)).collect(Collectors.toList());
    }

    public  List<StudentDto.Response> searchName(String name) throws Exception {
        List<Student> findStudents = studentRepository.findByName(name);
        List<StudentDto.Response> result = findStudents.stream()
                .map(s -> StudentDto.Response.of(s))
                .collect(Collectors.toList());
        return result;
    }


    public String deleteStudent(Long id) throws Exception {
        return studentRepository.delete(id);
    }

    public StudentDto.Response updateStudent(Long id,StudentDto.Request studentDto) throws Exception {
        Student updatedStudent = studentRepository.update(id, studentDto);
        return StudentDto.Response.of(updatedStudent);
    }


    public String raiseGradeStudent(Long id) throws Exception {
        return studentRepository.raiseGrade(id);
    }





}
