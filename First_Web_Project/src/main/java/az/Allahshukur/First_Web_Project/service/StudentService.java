package az.Allahshukur.First_Web_Project.service;

import az.Allahshukur.First_Web_Project.Dto.SchoolDto;
import az.Allahshukur.First_Web_Project.Dto.StudentDto;
import az.Allahshukur.First_Web_Project.Dto.TeacherDto;
import az.Allahshukur.First_Web_Project.entity.StudentEntity;
import az.Allahshukur.First_Web_Project.entity.TeacherEntity;
import az.Allahshukur.First_Web_Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto findById(Integer id){
        Optional<StudentEntity> optional =studentRepository.findById(id);
        if (optional.isPresent()) {                // icerisinde opyekt varsa dovre gir
            return StudentDto.instance(studentRepository.findById(id).get());
        }
        else {
            return null;
        }
    }

    public List<StudentDto> findAll(String name, String surname, Integer age, BigDecimal scholarship) {

        List<StudentEntity> list;
        if (isAllEmpty(name,surname,age,scholarship)) {
            list= studentRepository.findAll();
        }
        else
        list= studentRepository.findByNameOrSurnameOrAgeOrScholarship(name,surname,age,scholarship);

        List<StudentDto> result= new ArrayList<>();

        for (StudentEntity st: list){
            StudentDto studentDto = new StudentDto();
            studentDto.setId(st.getId());
            studentDto.setName(st.getName());
            studentDto.setSurname(st.getSurname());
            studentDto.setAge(st.getAge());
            studentDto.setScholarship(st.getScholarship());

            if (st.getSchool() != null) {
                SchoolDto schoolDto = new SchoolDto();
                schoolDto.setId(st.getSchool().getId());
                schoolDto.setName(st.getSchool().getName());
                studentDto.setSchool(schoolDto);
            }
            List<TeacherDto> teacherList = new ArrayList<>();

            for (TeacherEntity teacherEntity: st.getTeacherList()){
                TeacherDto teacherDto = new TeacherDto();
                teacherDto.setId(teacherEntity.getId());
                teacherDto.setName(teacherEntity.getName());
                teacherList.add(teacherDto);
            }

            studentDto.setTeacherList(teacherList);
            result.add(studentDto);
        }
        return result;

    }

    public static boolean isAllEmpty(Object... objects) {
        for (Object obj: objects){
            if(obj != null && !obj.toString().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public StudentDto deleteById(Integer id){
        StudentDto studentDto =findById(id);
        studentRepository.deleteById(id);
        return studentDto;
    }

    public void save(StudentDto studentDto){
        studentRepository.save(studentDto.ToEntity());
    }

    public void update(StudentDto studentDto){
        if (studentRepository.getOne(studentDto.getId())==null) {
            throw new IllegalArgumentException("not found");
        }
        studentRepository.save(studentDto.ToEntity());
    }




}

