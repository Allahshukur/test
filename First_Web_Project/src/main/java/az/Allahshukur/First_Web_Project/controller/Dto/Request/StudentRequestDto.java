package az.Allahshukur.First_Web_Project.controller.Dto.Request;

import az.Allahshukur.First_Web_Project.Dto.SchoolDto;
import az.Allahshukur.First_Web_Project.Dto.StudentDto;
import az.Allahshukur.First_Web_Project.Dto.TeacherDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentRequestDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    private SchoolRequestDto school;
    private List<TeacherRequestDto> teachers;

    public StudentDto toStudentDto(){
        List<TeacherDto> teacherDtos= new ArrayList<>();
        if (this.getTeachers() !=null) {
            for (TeacherRequestDto teacherRequestDto : this.getTeachers()) {
                teacherDtos.add(new TeacherDto()
                        .setId(teacherRequestDto.getId())
                        .setName(teacherRequestDto.getName()));
            }
        }

        SchoolDto schoolDto=null;
        if (this.getSchool() != null) {
            new SchoolDto()
                    .setId(this.getSchool().getId())
                    .setName(this.getSchool().getName());
        }

        return new StudentDto()
                .setId(this.getId())
                .setName(this.getName())
                .setSurname(this.getSurname())
                .setAge(this.getAge())
                .setScholarship(this.getScholarship())
                .setSchool(schoolDto)
                .setTeacherList(teacherDtos);
    }

    public Integer getId() {
        return id;
    }

    public StudentRequestDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentRequestDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentRequestDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public StudentRequestDto setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public SchoolRequestDto getSchool() {
        return school;
    }

    public StudentRequestDto setSchool(SchoolRequestDto school) {
        this.school = school;
        return this;
    }

    public List<TeacherRequestDto> getTeachers() {
        return teachers;
    }

    public StudentRequestDto setTeachers(List<TeacherRequestDto> teachers) {
        this.teachers = teachers;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", scholarship=" + scholarship +
                ", school=" + school +
                ", teachers=" + teachers+
                '}';
    }
}
