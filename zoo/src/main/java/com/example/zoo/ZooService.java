package com.example.zoo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }



    public Zoo createZoo() {
        Animal lion = new Animal(null, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        List<Animal> animals = List.of(lion);
        Zoo zoo = new Zoo(null, "Fajne Zoo", "Gdansk", true, animals);
        return zooRepository.save(zoo);
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

    public List<Zoo> getAll() {
        update();
//        List<Zoo> allByOpenIsFalse = zooRepository.findAllByOpenIsFalse();
        List<Zoo> allById = zooRepository.findAllByIdGreaterThan(5);
//        return allByOpenIsFalse;
//        return zooRepository.findAll();
        return allById;
    }


    public void update() {
        zooRepository.updateZoo("AAA", true,2);
    }

//    public Animal createAnimal()
}
