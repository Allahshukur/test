package az.Allahshukur.First_Web_Project.Dto;

public class TeacherDto {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public TeacherDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
