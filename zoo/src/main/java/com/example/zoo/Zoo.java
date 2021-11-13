package com.example.zoo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private boolean open;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Animal> animals;

    public Zoo() {

    }

    public Zoo(Integer id, String name, String location, boolean open, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.open = open;
        this.animals = animals;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    public String toString() {
        return "Zoo {id="+id+", name="+name+", location="+location+", open="+open+", animals="+animals.toString()+"}";
    }
}
