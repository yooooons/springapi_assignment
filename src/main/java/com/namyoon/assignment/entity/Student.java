package com.namyoon.assignment.entity;

import com.namyoon.assignment.constant.Gender;
import com.namyoon.assignment.dto.StudentDto;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Student {
    Long id;
    int grade;
    int classRoom;
    String name;
    Gender gender;

    //Repository에서 id값을 지정해줄때 사용
    public void changeId(Long id) {
        this.id = id;
    }

    public Student updateStu(StudentDto.Request studentDto) throws Exception {
        Gender caseGender;
        switch (studentDto.getGender()) {
            case "m":
                caseGender = Gender.MALE;
                break;
            case "w":
                caseGender = Gender.FEMALE;
                break;
            default:
                throw new Exception("성별은 m or w 만 기입해 주세요");
        }
        grade = studentDto.getGrade();
        classRoom = studentDto.getClassRoom();
        name = studentDto.getName();
        gender = caseGender;
        return this;
    }

    public Student raiseGrade() throws Exception {
        if (this.grade == 6) {
            throw new Exception("해당 학생은 졸업반입니다.");
        }
        grade++;
        return this;
    }


}
