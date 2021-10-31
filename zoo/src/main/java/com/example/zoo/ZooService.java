package com.example.zoo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    public Zoo createZoo() {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        List<Animal> animals = List.of(lion);
        return new Zoo(1, "Fajne Zoo", "Gdansk", true, animals);
    }

    public Zoo createNullZoo() {
//        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
//        List<Animal> animals = List.of(lion);
        return new Zoo(1, "Fajne Zoo", "Gdansk", true, null);
    }

    public Zoo createZoo(String name) {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        List<Animal> animals = List.of(lion);
        return new Zoo(1, name, "Gdansk", true, animals);
    }

//    public Animal createAnimal()
}
