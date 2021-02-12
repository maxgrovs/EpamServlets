package by.epam.grovs.servlet.dto;

import by.epam.grovs.servlet.entity.Film;

public class FilmDto {

    private Long id;
    private String name;
    private Integer year;

    public FilmDto(Long id, String name, Integer year) {
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
        return "FilmDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public static FilmDto.Builder builder() {
        return new FilmDto.Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private Integer year;

        public FilmDto.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public FilmDto.Builder name(String name) {
            this.name = name;
            return this;
        }

        public FilmDto.Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public FilmDto build(){

            return
                    new FilmDto(
                            this.id,
                            this.name,
                            this.year
                    );
        }
    }


}
