package az.Allahshukur.First_Web_Project.controller;

import az.Allahshukur.First_Web_Project.Dto.StudentDto;
import az.Allahshukur.First_Web_Project.Dto.TeacherDto;
import az.Allahshukur.First_Web_Project.controller.Dto.Request.StudentRequestDto;
import az.Allahshukur.First_Web_Project.controller.Dto.Response.SchoolResponseDto;
import az.Allahshukur.First_Web_Project.controller.Dto.Response.StudentResponseDto;
import az.Allahshukur.First_Web_Project.controller.Dto.Response.TeacherResponseDto;
import az.Allahshukur.First_Web_Project.entity.StudentEntity;
import az.Allahshukur.First_Web_Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping(value="Rest/Students")
public class StudentEndPoint {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDto> index(
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
    ) {
        List<StudentDto> list= studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );

        List<StudentResponseDto> result= new ArrayList<>();

        for (StudentDto st: list){
            result.add(StudentResponseDto.instance(st));
        }
        return result;
    }

    @GetMapping(value = "/{id}")
    public StudentResponseDto getById(@PathVariable("id") Integer id)  {
        return StudentResponseDto.instance(studentService.findById(id));
    }

    @PostMapping
    public String Add(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.save(studentRequestDto.toStudentDto());
        return studentRequestDto.toString();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<StudentResponseDto> deleteById(@PathVariable("id") Integer id){
        if (studentService.findById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(StudentResponseDto.instance(studentService.deleteById(id)));
    }

    @PutMapping
    public String update(@RequestBody StudentRequestDto studentRequestDto){
        studentService.update(studentRequestDto.toStudentDto());
        return "success";
    }
}
