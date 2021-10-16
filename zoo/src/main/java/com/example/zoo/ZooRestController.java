package com.example.zoo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// to jest moj pierwszy endpoint
// po to zeby string traktowal to jako endpoint
// @ - oznaczamy adnotacje, czyli dodatkowe zachowanie schowane pod tego typu klasami
// musimy mu powiedziec na jaki adres ma reagowac - @RequestMapping("/sciezka")
// teraz kontroler wie, ze zadania localhost/zoo ida do tego wora
// ResponseEntity - pozwala zarzadzac statusami
@RestController
@RequestMapping("/zoo")
public class ZooRestController {


    //przekazuje jeszcze jaka metoda ma obsluzyc ta zadanie
    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        Animal lion = new Animal(1, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        List<Animal> animals = List.of(lion);
        Zoo zoo = new Zoo(1, "Fajne Zoo", "Gdansk", true, animals);
        return ResponseEntity.ok(zoo);
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> getExampleZooNullAnimal() {
        Zoo zoo2 = new Zoo(1, "Fajne Zoo", "Gdansk", true, null);
        return ResponseEntity.ok(zoo2);
    }
}
