package az.Allahshukur.First_Web_Project.repository;

import az.Allahshukur.First_Web_Project.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {


    List<StudentEntity> findByNameOrSurnameOrAgeOrScholarship(String name, String surname, Integer age, BigDecimal scholarship);

//    @Query(value = "select s from StudentEntity s where s.school.id=:id and s.age=:age") //JPQL ile yazilisi.
//    List<StudentEntity> findAllBySchoolIdAndAge(@Param("id") Integer id, @Param("age") Integer age);
//
//    @Query(nativeQuery = true,value = "select s.* from student s where s.school_id=:id and s.age=:age")
//    List<StudentEntity> findAllBySchoolIdAndAge2(@Param("id") Integer id , @Param("age") Integer age);
}
