package com.example.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooApplication.class, args);

		/*
		Klasa zoo
		Zoo -> id, name, location, is closed?, list Animal
		Klasa animal
		Animal -> id, specimen, diet (meat,vege,mixed), type (water,land,air),hunger,health


		 */

		// Utworzyc nowego animala
		// Utworzyc nowa liste
		// Dodac Animala do listy
		// Utworzyc nowe zoo
		// Wypisac na ekran zoo


		// MVC
		// Model - schemat bazy danych
		// View - interfejs uzytkownika
		// Controller - konwersja danych na model od widoku

		// W springu zamiast view jest service


		// Do przeczytania: @RestController, @Service, Wstrzykiwanie zaleznosci

		// Do przeczytania: Co to @Repository, jak zaimplementowac, jak zapisywac do bazy danych, jak odczytywac z bazy danych


		// robimy crud repository i wstrzykujemy do service'u

		// dokonczyc wszystkie testy i poczytac o Mockito
		//pytania na projekt:
		//co to jest spring, spring boot, git, po co git i merge requesty, po co commity, co to jest wstrzykiwanie zależności,
		//co to są testy jednostkowe, integracyjne, co to jest serwis, kontroler
	}

}
