package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() throws SQLException {
    Film f = db.getFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_getActorsById_returns_list_of_actors() throws SQLException{
	  Film f = db.getFilmById(42);
	  List<Actor> actors = db.getActorsByFilmId(42);
	  
  }

}
