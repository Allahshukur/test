package az.Allahshukur.First_Web_Project.controller;

import az.Allahshukur.First_Web_Project.Dto.StudentDto;
import az.Allahshukur.First_Web_Project.entity.StudentEntity;
import az.Allahshukur.First_Web_Project.repository.StudentRepository;
import az.Allahshukur.First_Web_Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value="Students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping()
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
    ) {

        List<StudentDto> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );
        model.addAttribute("list",list);
        return "Students/students";
    }

    @PostMapping(value = "/add")
    public String Add(@ModelAttribute StudentEntity studentEntity) {
        studentRepository.save(studentEntity);

        return "redirect:/Students";
    }

    @PostMapping(value = "/update")
    public String Update(@ModelAttribute StudentEntity studentEntity) {
        studentRepository.save(studentEntity);

        return "redirect:/Students";
    }

    @PostMapping(value = "/delete")
    public String Delete(@RequestParam(required = false) Integer id) {
        studentRepository.deleteById(id);

        return "redirect:/Students";
    }


}
