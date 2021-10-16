package com.example.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int id;
    private String name;
    private String location;
    private boolean open;
    private List<Animal> animals;

    public Zoo(int id, String name, String location, boolean open, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.open = open;
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean isOpen() {
        return open;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<Animal>(animals);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String toString() {
        return "Zoo {id="+id+", name="+name+", location="+location+", open="+open+", animals="+animals.toString()+"}";
    }
}
