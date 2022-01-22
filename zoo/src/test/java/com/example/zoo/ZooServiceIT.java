package com.example.zoo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
public class ZooServiceIT {

    @Autowired
    private ZooService zooService;

    @MockBean
    private ZooRepository zooRepository;


    @Test
    void shouldAddSuffixToName() {
        // GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, List.of());
        // WHEN
        zooService.addSuffixToName(zoo);
        // THEN
        assertThat(zoo.getName()).isEqualTo("Gdanskie zoo_SUFFIX");
    }

    @Test
    void shouldNotAddSuffixToName() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "gdansk", true, List.of());
        //WHEN
        zooService.addSuffixToName(zoo);
        //THEN
        assertThat(zoo.getName()).isNull();
    }

    @Test
    void shouldNotHaveAnimalInZoo() {
        // GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, null);
        // WHEN
        zooService.addAnimalToZoo(zoo, null);
    }

    @Test
    void shouldFindById() {
        // kiedy ktos wywola taka metode wtedy zwroc
        // Arguments
        Mockito.when(zooRepository.findById(any()))
                .thenReturn(Optional.of(new Zoo()));

        Zoo byId = zooService.findById(1);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldNotFindById() {
        // repo zwraca nam Optional.empty()
        Mockito.when(zooRepository.findById(any())).thenReturn(Optional.empty());

        Zoo byId = zooService.findById(10);

        assertThat(byId).isNull();
    }

    // getAll -> co jak zwroci x elementow, co jak zwroci pusta liste
    // zooExists -> co jak exists co jak nie exists
    // deleteZooById -> sprawdzic czy bylo wywolane

    @Test
    void shouldGetAll() {
        List<Zoo> zooList = List.of(new Zoo(), new Zoo());
        Mockito.when(zooRepository.findAll())
                .thenReturn(zooList);

        List<Zoo> all = zooService.getAll();

        assertThat(all).hasSize(zooList.size());
    }


    @Test
    void shouldExistZoo() {
        Mockito.when(zooRepository.existsById(any())).thenReturn(true);

        boolean zooExistsById = zooService.existsById(1);
        assertThat(zooExistsById).isTrue();
    }


    // w przypadku metod void robi sie doNothing().when(zooRepository).deleteById(any())
//    @Test
//    void shouldDelete() {
//        zooService.deleteById(1);
//
//        verify(zooRepository, times(2)).deleteById(any());
//
//    }

    @Test
    void shouldAnimalListNotBeEmpty() {
        //GIVEN
        Animal animal = new Animal(1, "tygrys", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, List.of(animal));
        //WHEN
        zooService.isAnimalListEmpty(zoo);
        //THEN
        assertThat(zoo.getAnimals()).isNotEmpty();
    }
    @Test
    void shouldChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "Gdansk", true, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "Krakow");
        //THEN
        assertThat(zoo.getLocation()).isNotNull();
    }
    @Test
    void shouldNotChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, null, true, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "Krakow");
        //THEN
        assertThat(zoo.getLocation()).isNull();
    }
    @Test
    void shouldChangeDiet() {
        //GIVEN
        Animal animal = new Animal(null, null, Diet.MEAT, null, false, null);
        //WHEN
        zooService.changeAnimalDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isEqualTo(Diet.MIXED);
    }
    @Test
    void shouldNotChangeAnimalDiet() {
        //GIVEN
        Animal animal = new Animal(null, null, null, null, false, null);
        //WHEN
        zooService.changeAnimalDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isNull();
    }

    @Test
    void shouldGetEmptyZooList() {
        List<Zoo> zooList = List.of();
        Mockito.when(zooRepository.findAll())
                .thenReturn(zooList);

        List<Zoo> all = zooService.getAll();

        assertThat(all).isEmpty();
    }


    @Test
    void shouldExistsById() {
        Mockito.when(zooRepository.existsById(any()))
                .thenReturn(true);

        boolean exists = zooService.zooExistById(1);

        assertThat(exists).isTrue();
    }

    @Test
    void shouldNotExistsById() {
        Mockito.when(zooRepository.existsById(any()))
                .thenReturn(false);

        boolean exists = zooService.zooExistById(1);

        assertThat(exists).isFalse();
    }

    @Test
    void shouldDeleteZooById() {
        zooService.deleteById(1);

        Mockito.verify(zooRepository).deleteById(any());
    }
}
