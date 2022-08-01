package com.namyoon.assignment.dto;

import com.namyoon.assignment.constant.Gender;
import com.namyoon.assignment.entity.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class StudentDto {
    @Builder
    @Getter
    @Setter
    public static class Request {
        int grade;
        int classRoom;
        String name;
        String gender;

        public Student toEntity() throws Exception {
            Gender caseGender;
            switch (gender) {
                case "m":
                    caseGender = Gender.MALE;
                    break;
                case "w":
                    caseGender = Gender.FEMALE;
                    break;
                default:
                    throw new Exception("성별은 m or w 만 기입해 주세요");
            }
            
            Student student = Student.builder()
                    .grade(this.grade)
                    .classRoom(this.classRoom)
                    .name(this.name)
                    .gender(caseGender)
                    .build();
            return student;
        }
    }

    @Getter
    @Builder
    public static class Response {
        Long id;
        int grade;
        int classRoom;
        String name;
        String gender;

        public static StudentDto.Response of(Student student) {
            return StudentDto.Response.builder()
                    .id(student.getId())
                    .grade(student.getGrade())
                    .classRoom(student.getClassRoom())
                    .name(student.getName())
                    .gender(student.getGender().getGender())
                    .build();
        }

    }
}

