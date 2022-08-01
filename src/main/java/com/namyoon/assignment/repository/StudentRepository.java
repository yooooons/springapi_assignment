package com.namyoon.assignment.repository;

import com.namyoon.assignment.dto.StudentDto;
import com.namyoon.assignment.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.lang.reflect.Member;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Repository
public class StudentRepository {
    private Map<Long, Student> studentDb = new HashMap<>();
    private Long sequence = 0L;


    public Student save(Student student) {
        sequence++;
        student.changeId(sequence);
        studentDb.put(student.getId(), student);
        return student;
    }


    public Student findById(Long id) throws Exception {
        if (studentDb.get(id) == null) {
            throw new Exception("학생을 찾을수 없습니다.");
        } else {
            return studentDb.get(id);
        }
    }

    public List<Student> findAll() throws Exception {
        if (studentDb.values().isEmpty()) {
            throw new Exception("학생을 찾을수 없습니다.");
        } else {
            return new ArrayList<>(studentDb.values());
        }

    }


    public List<Student> findByName(String name) throws Exception {
        try {
            List<Student> result = studentDb.values().stream()
                    .filter(s -> s.getName().equals(name))
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                throw new Exception("학생을 찾을수 없습니다.");
            }
            return result;
        } catch (NullPointerException e) {
            throw new Exception("학생을 찾을수 없습니다.");
        }
    }


    public String delete(Long id) throws Exception {
        if (studentDb.get(id) == null) {
            throw new Exception("삭제하려는 학생이 없습니다.");
        } else {
            studentDb.remove(id);
            return "해당 학생정보를 삭제하였습니다.";
        }
    }

    public Student update(Long id, StudentDto.Request studentDto) throws Exception {

        if (studentDb.get(id) == null) {
            throw new Exception("수정하려는 학생이 없습니다.");
        }

        return studentDb.get(id).updateStu(studentDto);
    }

    public String raiseGrade(Long id) throws Exception {

        if (studentDb.get(id) == null) {
            throw new Exception("진급하려는 학생을 찾을수 없습니다.");
        }
        studentDb.get(id).raiseGrade();
        return "해당 학년의 학년을 올렸습니다.";
    }



    public Boolean validate(Student student) {
        List<Student> students = studentDb.values().stream()
                .filter(s -> s.getName().equals(student.getName())
                        && s.getClassRoom() == student.getClassRoom()
                        && s.getGender().equals(student.getGender())
                        && s.getGrade() == student.getGrade())
                .collect(Collectors.toList());

        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

}
