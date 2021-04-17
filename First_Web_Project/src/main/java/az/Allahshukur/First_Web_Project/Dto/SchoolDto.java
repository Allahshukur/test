package az.Allahshukur.First_Web_Project.Dto;

public class SchoolDto {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public SchoolDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "SchoolDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
