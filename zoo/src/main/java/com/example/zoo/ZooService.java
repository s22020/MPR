package com.example.zoo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//        update();
//        List<Zoo> allByOpenIsFalse = zooRepository.findAllByOpenIsFalse();
//        List<Zoo> allById = zooRepository.findAllByIdGreaterThan(5);
//        return allByOpenIsFalse;
//        return zooRepository.findAll();
        return zooRepository.findAll();
    }


    public void update() {
        zooRepository.updateZoo("AAA", true,2);
    }

//    public Animal createAnimal()

    public Zoo findById(Integer id) {
        Zoo zoo = null; // DB query
        Optional<Zoo> byId = zooRepository.findById(id);

        // orElse - zwroc mi obiekt jakis chyba ze go nie ma
        // to zwroc mi obiekt w ciele
        return byId.orElse(null);
    }

    // 6 method, zmienic zwierzeciu diete, specimen itp
    public void addSuffixToName(Zoo zoo) {
        if (zoo.getName() != null) {
            String suffixName = zoo.getName() + "_SUFFIX";
            zoo.setName(suffixName);
        }
    }

    public void addAnimalToZoo(Zoo zoo, Animal animal) {
        if (zoo.getAnimals() != null) {
            zoo.getAnimals().add(animal);
        }
    }

    public void changeAnimalDiet(Animal animal, Diet diet) {
        if (animal.getDiet() != null) {
            animal.setDiet(diet);
        }
    }

    public void changeZooLocation(Zoo zoo, String location) {
        if (zoo.getLocation() != null) {
            zoo.setLocation(location);
        }
    }


    public void checkLocation(Zoo zoo) {
        if (zoo.getLocation() != null) {
            if (zoo.getLocation().equals("Kenia")) {
                zoo.setLocation("");
            }
        }
    }

    public void checkDisallowedName(Zoo zoo) {
        if (zoo.getName() != null && zoo.getName().equals("Disallowed name")) {
            zoo.setName("");
        }
    }

    public void checkZooTooLarge(Zoo zoo) {
        if (zoo.getAnimals() != null && zoo.getAnimals().toArray().length > 300) {
            zoo.setAnimals(null);
        }
    }

    // do dopisania: existsById, delete / deleteById
    public boolean existsById(Integer id) {
        return zooRepository.existsById(id);
    }

    public boolean isAnimalListEmpty(Zoo zoo) {
        if (zoo.getAnimals().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteById(Integer id) {
        zooRepository.deleteById(id);
    }

    public boolean zooExistById(Integer id) {
        return zooRepository.existsById(id);
    }

}
