package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.FilmInventory;
import com.skilldistillery.filmquery.entities.Language;

public interface DatabaseAccessor{
  public Film getFilmById(int filmId) throws SQLException;
  public Actor getActorById(int actorId) throws SQLException;
  public List<Actor> getActorsByFilmId(int filmId) throws SQLException;
  public List<Film> getFilmBySearchTerm(String searchTerm) throws SQLException;
  public Language getLanguageOfFilm(int filmId) throws SQLException;
  public Film getAllFilmDetails(int filmId) throws SQLException;
  public Film getFilmCategories(int filmId) throws SQLException;
  public List<FilmInventory> getFilmInventory(int filmId) throws SQLException;
}
