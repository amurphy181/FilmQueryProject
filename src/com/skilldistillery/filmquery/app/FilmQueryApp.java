package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.FilmInventory;
import com.skilldistillery.filmquery.entities.Language;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.getFilmById(900);
		System.out.println(film);
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		int choice = initialMenu();

		startUserInterface(choice);

		input.close();
	}

	private void startUserInterface(int choice) throws SQLException {
		Scanner input = new Scanner(System.in);

		do {
			switch (choice) {
			case 1:
				System.out.print("Please enter the film's ID:");
				int filmId = input.nextInt();
				Film film = db.getFilmById(filmId);
				try {
					if (film == null) {
						System.out.println("No film here!");
						input.nextLine();
					}
				} catch (NullPointerException n) {
					System.out.println("No film with that ID!");
				}
				if (film != null) {
					Language filmLanguage = db.getLanguageOfFilm(filmId);
					System.out.println(film.byIdToString(film));
					System.out.println(filmLanguage);
					System.out.println("Actors and Actresses:\n");
					System.out.println(film.actorsListedInFilm(film.getActors()));
					System.out.println("Would you like to:\n\t1: Return to Main Menu, or\n\t2. View All Film Details?");
					int returnToMenuOrViewDetails = input.nextInt();
					switch (returnToMenuOrViewDetails) {
					default:
					case 1:
						break;
					case 2:
						Film filmCategory = db.getFilmCategories(filmId);
						List<FilmInventory> inventory = db.getFilmInventory(filmId);
						System.out.println(film.allMovieDetails());
						System.out.println("Category: " + filmCategory.filmCategoriesReturned() + "\n");
						System.out.println("Would you like to view inventory details for this film? (Y/N)");
						String inventoryChoice = input.nextLine();
						switch (inventoryChoice) {
						case "Y":
							FilmInventory fi = new FilmInventory();
							System.out.println("Inventory:\n" + fi.filmInventoryPrinter(inventory));
							input.nextLine();
							break;
						default:
							break;
						}
						break;
					}
					input.nextLine();
				}
				break;
			case 2:

				System.out.print("Please enter your search term:");
				String searchTerm = input.nextLine();
				List<Film> films = db.getFilmBySearchTerm(searchTerm);
				try {
					if (films.isEmpty()) {
						System.out.println("No films containing that term!");
						break;
					}
				} catch (NullPointerException n) {
					System.out.println(n);
				}
				if (!films.isEmpty()) {
					for (Film film2 : films) {
						int filmIDforSearch = film2.getId();
						Language filmLanguage = db.getLanguageOfFilm(filmIDforSearch);

						System.out.print(film2.byIdToString(film2));
						System.out.println(filmLanguage);
						System.out.println("Actors and Actresses:\n");
						System.out.println(film2.actorsListedInFilm(film2.getActors()));
					}
				}
			case 3:
			default:
			}
			choice = secondaryMenu();
		} while (choice != 3);

		System.out.println("Good-bye!");
	}

	private int initialMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Good afternoon. Please select from the following options:");
		System.out.println("1. Look up a film by its ID");
		System.out.println("2. Look up a film by a keyword");
		System.out.println("3. Exit the application");

		int choice = input.nextInt();
		return choice;

	}

	private int secondaryMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nWelcome back! Please select from the following options:");
		System.out.println("1. Look up a film by its ID");
		System.out.println("2. Look up a film by a keyword");
		System.out.println("3. Exit the application");

		int choice = input.nextInt();
		return choice;
	}

}
