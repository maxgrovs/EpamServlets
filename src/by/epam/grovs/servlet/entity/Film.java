package by.epam.grovs.servlet.entity;

public class Film {

    private Long id;
    private String name;
    private Integer year;

    public Film(Long id, String name, Integer year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public static Film.Builder builder() {
        return new Film.Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private Integer year;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Film build(){

            return
            new Film(
                    this.id,
                    this.name,
                    this.year
            );
        }
    }


}
