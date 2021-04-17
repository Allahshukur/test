package az.Allahshukur.First_Web_Project.controller.Dto.Request;

public class TeacherRequestDto {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public TeacherRequestDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherRequestDto setName(String name) {
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
