package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

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
					}
				} catch (NullPointerException n) {
					System.out.println("No film with that ID!");
				}
				if (film != null) {
					System.out.println(film.byIdToString());
				}
				break;
			case 2:

				System.out.print("Please enter your search term:");
				String searchTerm = input.nextLine();
				List<Film> films = db.getFilmBySearchTerm(searchTerm);
				Film tempFilm = new Film();
				try {
					if (films.isEmpty()) {
						System.out.println("No films containing that term!");
						break;
					}
				} catch (NullPointerException n) {
					System.out.println(n);
				}
				if (!films.isEmpty()) {
					System.out.println(tempFilm.toStringWithLanguage(films));
				}
			case 3:
			default:
			}
			choice = initialMenu();
		} while (choice != 3);

		System.out.println("choice made");
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

}
