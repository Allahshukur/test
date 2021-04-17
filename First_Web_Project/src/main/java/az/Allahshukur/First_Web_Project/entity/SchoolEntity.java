package az.Allahshukur.First_Web_Project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="school")
public class SchoolEntity {

    @Id
    private Integer id;
    private String name;

    @OneToMany
    private List<StudentEntity> studentlist;

    @OneToOne(mappedBy = "school", cascade = CascadeType.ALL)
    private SchoolAdress schoolAdress;

    public Integer getId() {
        return id;
    }

    public SchoolEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<StudentEntity> getStudentlist() {
        return studentlist;
    }

    public SchoolEntity setStudentlist(List<StudentEntity> studentlist) {
        this.studentlist = studentlist;
        return this;
    }

    public SchoolAdress getSchoolAdress() {
        return schoolAdress;
    }

    public SchoolEntity setSchoolAdress(SchoolAdress schoolAdress) {
        this.schoolAdress = schoolAdress;
        return this;
    }

    @Override
    public String toString() {
        return "SchoolEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
