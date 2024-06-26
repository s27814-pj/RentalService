package com.example2.RentalService;

//import jakarta.persistence.*;

public class Movie {
    private Long id;
    private String name;
    private Category category;

    private boolean isAvailable = false;

    public Movie(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Movie(){

    }
//    public Movie(String name, String category) {
//        this.id = 5L;
//        this.name = name;
//        this.category = category;
//    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
