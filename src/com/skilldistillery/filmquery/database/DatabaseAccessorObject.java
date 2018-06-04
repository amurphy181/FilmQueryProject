package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Language;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	
	@Override
	public List<Film> getFilmBySearchTerm(String searchTerm) throws SQLException {
		List<Film> films = new ArrayList<>();
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sqltext = "SELECT id, title, release_year, rating, description FROM film WHERE title like ?";
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setString(1, "%" + searchTerm + "%");
		ResultSet searchResult = stmt.executeQuery();
		while(searchResult.next()) {
			Actor actor = new Actor();
			int id = searchResult.getInt(1);
			String title = searchResult.getString(2);
			int releaseYear = searchResult.getInt(3);
			String rating = searchResult.getString(4);
			String description = searchResult.getString(5);
			Language language = getLanguageOfFilm(id);
			List<Actor> actors = getActorsByFilmId(id);
			StringBuilder actorList = actor.actorsListed(actors);
			
			Film film = new Film(title, releaseYear, description, rating, language, actors);
			
			films.add(film);
		}
		searchResult.close();
	    stmt.close();
	    conn.close();
		return films;
	}

	@Override
	//title, year, rating, and description are displayed when this is returned
	public Film getFilmById(int filmId) throws SQLException {
		Film film = null;
		Film filmFull = null;
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = "SELECT id, title, release_year, rating, description, language_id, rental_duration,"
				+ "rental_rate, length, replacement_cost, special_features FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			// Here is our mapping of query columns to our object fields:
//			Actor actor = new Actor();
			int id = filmResult.getInt(1);
			String title = filmResult.getString(2);
			int releaseYear = filmResult.getInt(3);
			String rating = filmResult.getString(4);
			String description = filmResult.getString(5);
			int languageId = filmResult.getInt(6);
			int rentalDuration = filmResult.getInt(7);
			double rentalRate = filmResult.getDouble(8);
			int length = filmResult.getInt(9);
			double replacementCost = filmResult.getDouble(10);
			String specialFeatures= filmResult.getString(11);
			Language language = getLanguageOfFilm(id);
			List<Actor> actors = getActorsByFilmId(id);
//			StringBuilder actorList = actor.actorsListed(actors);
			filmFull = new Film(id, title, description, releaseYear, languageId, 
					rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, language, actors);
					
			
			film = new Film(title, releaseYear, description, rating, language, actors); // Create the object
		}
		filmResult.close();
	    stmt.close();
	    conn.close();
	    return filmFull;

	}

	@Override
	public Actor getActorById(int actorId) throws SQLException {
		Actor actor = null;
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			actor.setId(actorResult.getInt(1));
			actor.setFirstName(actorResult.getString(2));
			actor.setLastName(actorResult.getString(3));
		}
		actorResult.close();
	    stmt.close();
	    conn.close();
		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		  try {
			  Connection conn = DriverManager.getConnection(URL, "student", "student");
		    String sql = "SELECT a.id, a.first_name, a.last_name FROM film f JOIN film_actor"
		    		+ " ON film_actor.film_id = f.id JOIN actor a ON film_actor.actor_id = a.id"
		               + " WHERE film_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, filmId);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		      int actorId = rs.getInt(1);
		      String firstName = rs.getString(2);
		      String lastName = rs.getString(3);
		      
		      Actor actor = new Actor(actorId, firstName, lastName);
		      actors.add(actor);
		    }
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return actors;
	}

	@Override
	public Language getLanguageOfFilm(int filmId) throws SQLException {
		Language language = null;
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = "SELECT l.name FROM film f JOIN language l on l.id = f.language_id WHERE f.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			language = new Language();
			language.setLanguage(rs.getString(1));
		}
		rs.close();
	    stmt.close();
	    conn.close();
		return language;
	}

	
	@Override
	public Film getAllFilmDetails(int filmId) throws SQLException {
		Film film = null;
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = "SELECT id, title, description, release_year, language_id, rental_duration, rental_rate, "
				+ "length, replacement_cost, rating, special_features FROM film WHERE film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmDetails = stmt.executeQuery();
		if (filmDetails.next()) {
			int id = filmDetails.getInt(1);
			String title = filmDetails.getString(2);
			String description = filmDetails.getString(3);
			int releaseYear = filmDetails.getInt(4);
			int languageId = filmDetails.getInt(5);
			int rentalDuration = filmDetails.getInt(6);
			double rentalRate = filmDetails.getDouble(7);
			int length = filmDetails.getInt(8);
			double replacementCost = filmDetails.getDouble(9);
			String rating = filmDetails.getString(10);
			String specialFeatures = filmDetails.getString(11);
			film = new Film(id, title, description, releaseYear, languageId, rentalDuration, 
					rentalRate, length, replacementCost, rating, specialFeatures); // Create the object
		}
		filmDetails.close();
	    stmt.close();
	    conn.close();
		return film;
	}

	@Override
	public Film getFilmCategories(int filmId) throws SQLException {
		Film film = null;
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = " SELECT cat.name FROM film f JOIN film_category fc ON fc.film_id = f.id JOIN category cat ON fc.category_id = cat.id WHERE f.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmCategories = stmt.executeQuery();
		if(filmCategories.next()) {
			String categories = filmCategories.getString(1);
			film = new Film(categories);
		}
		filmCategories.close();
	    stmt.close();
	    conn.close();
		return film;
	}

	

}
