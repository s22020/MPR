package com.example.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

	}

}