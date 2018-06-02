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
			
			int id = searchResult.getInt(1);
			String title = searchResult.getString(2);
			int releaseYear = searchResult.getInt(3);
			String rating = searchResult.getString(4);
			String description = searchResult.getString(5);
			Language language = getLanguageOfFilm(id);
			
			Film film = new Film(title, releaseYear, description, rating, language);
			
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
		Connection conn = DriverManager.getConnection(URL, "student", "student");
		String sql = "SELECT id, title, release_year, rating, description FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			// Here is our mapping of query columns to our object fields:
			film = new Film(); // Create the object
			
			film.setTitle(filmResult.getString(2));
			film.setReleaseYear(filmResult.getInt(3));
			film.setRating(filmResult.getString(4));
			film.setDescription(filmResult.getString(5));
		}
		filmResult.close();
	    stmt.close();
	    conn.close();
	    return film;

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
		    String sql = "SELECT id, first_name, last_name"
		               +  " FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
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

	

}
