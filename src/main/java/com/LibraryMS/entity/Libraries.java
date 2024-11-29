package com.LibraryMS.entity;

import javax.persistence.*;

@Entity
@Table(name="Libraries")
public class Libraries {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;  // Changed from int to Integer

    private String name;
    private String place;

    // Default constructor
    public Libraries() {
    }

    // Parameterized constructor
    public Libraries(Integer id, String name, String place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
