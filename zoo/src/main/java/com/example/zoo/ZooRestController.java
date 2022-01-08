package com.example.zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // dependency injection
    private final ZooService zooService;

    public ZooRestController(ZooService zooService) {
        this.zooService = zooService;
    }


    //przekazuje jeszcze jaka metoda ma obsluzyc ta zadanie
    @GetMapping("/example")
    public ResponseEntity<Zoo> createExampleZoo() {
        return ResponseEntity.ok(zooService.createZoo());
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> createExampleZooNullAnimal(@RequestParam String name) {
        return ResponseEntity.ok(zooService.createNullZoo());
    }

    @GetMapping("/zooname")
    public ResponseEntity<Zoo> createExampleZooName() {
        return ResponseEntity.ok(zooService.createZoo("Nowa nazwa"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Zoo>> getAllZoos() {
        return ResponseEntity.ok(zooService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zoo> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(zooService.findById(id));
    }


}
