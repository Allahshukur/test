package az.Allahshukur.First_Web_Project.controller.Dto.Response;

public class SchoolResponseDto {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
