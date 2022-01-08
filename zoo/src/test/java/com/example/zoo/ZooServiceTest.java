package com.example.zoo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ZooServiceTest {
    @Mock
    private ZooRepository zooRepository;

    // inicjalizacja testowanego service'u
    // null tylko na potrzeby testow metod nie uzywajacych bazy danych
    // @InjectMocks - zeby zooRepository nie bylo nullem
    @InjectMocks
    private ZooService zooService;
    // testy zapisuje sie w konwencji given-when-then


    @Test
    void shouldAddSuffixToName() {
        // GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, List.of());
        // WHEN
        zooService.addSuffixToName(zoo);
        // THEN, uzycie asercji (metody sprawdzajace dane (warunek do danych, takie ify))
        // w asercji podajemy obiekt, ktory chcemy sprawdzic
        assertThat(zoo.getName()).isEqualTo("Gdanskie zoo_SUFFIX");
    }

    @Test
    void shouldNotDoAnything() {
        // GIVEN
        Zoo zoo = new Zoo(null, null, "Gdansk", true, List.of());
        // WHEN
        zooService.addSuffixToName(zoo);
        // THEN
        assertThat(zoo.getName()).isNull();
    }

    @Test
    void shouldAddAnimalToZoo() {
        // GIVEN
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, List.of());
        Animal animal = new Animal(null, "lion", Diet.MEAT, Type.LAND, false, Health.HEALTHY);
        // WHEN
        zooService.addAnimalToZoo(zoo, animal);
        // THEN
        assertThat(zoo.getAnimals()).isNotNull().hasSize(1);
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
    void shouldFindAll() {
        List<Zoo> zoos = new ArrayList<>();
        Zoo zoo = new Zoo(1, "Gdanskie zoo", "Gdansk", true, null);
        zoos.add(1, zoo);
        Mockito.when(zooRepository.findAll()).thenReturn(zoos);

        List<Zoo> all = zooService.getAll();

        assertThat(all).hasSize(zoos.size());

    }

    @Test
    void shouldGetEmptyZooList() {
        List<Zoo> zoos = List.of();
        Mockito.when(zooRepository.findAll()).thenReturn(zoos);

        List<Zoo> all = zooService.getAll();

        assertThat(all).isEmpty();

    }

    @Test
    void shouldExistZoo() {
        Mockito.when(zooRepository.existsById(any())).thenReturn(true);

        boolean zooExistsById = zooService.existsById(1);
        assertThat(zooExistsById).isTrue();
    }


    // w przypadku metod void robi sie doNothing().when(zooRepository).deleteById(any())
    @Test
    void shouldDelete() {
        zooService.deleteById(1);

        verify(zooRepository, times(2)).deleteById(any());

    }
}
