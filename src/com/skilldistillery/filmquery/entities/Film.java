package com.skilldistillery.filmquery.entities;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class Film {
	DatabaseAccessorObject dao = new DatabaseAccessorObject();
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private Language language;
	private StringBuilder actorList;
	private String categories;

	public Film(String categories) throws SQLException {
		super();
		this.setCategories(categories);
	}
	
	public StringBuilder filmCategoriesReturned() {
		StringBuilder filmCategory = new StringBuilder();
		filmCategory.append(categories);
		return filmCategory;
	}

	public Film(String title, int releaseYear, String description, String rating, Language language, List<Actor> actors)
			throws SQLException {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.language = language;
		this.actors = actors;
	}

	public Film(String title, int releaseYear, String description, String rating) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}

	public Film(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures)
			throws SQLException {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;

	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors) throws SQLException {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;

	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			Language language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public void setActors(List<Actor> actorsByFilmId) {
		this.actors = actorsByFilmId;

	}

	public List<Actor> getActors() {
		return actors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film title = ").append(title).append("\nRelease year: ").append(releaseYear)
				.append("\nRating: ").append(rating).append("\nDescription: ").append(description).append("\n");
		return builder.toString();
	}

	public String byIdToString(Film film) { // title, year, rating, and description are displayed.
		StringBuilder builder = new StringBuilder();
		Language language = film.language;
		builder.append("Film title = ").append(title).append("\nRelease year: ").append(releaseYear)
				.append("\nRating: ").append(rating).append("\nDescription: ").append(description)
				.append("\nLanguage: " + language + "\n");
		return builder.toString();
	}

	public StringBuilder toStringWithLanguageAndActors(List<Film> films) throws SQLException {
		StringBuilder builder = new StringBuilder();
		for (Film film : films) {
			DatabaseAccessorObject actorsInFilm = new DatabaseAccessorObject();
			Actor actor = new Actor();
			StringBuilder actorList = new StringBuilder("");

			int filmId = film.getId();
			String title = film.getTitle();
			int releaseYear = film.getReleaseYear();
			String rating = film.getRating();
			String description = film.getDescription();
			Language language = film.language;
			List<Actor> actors = actorsInFilm.getActorsByFilmId(filmId);
			actorList = actor.actorsListed(actors);

			builder.append("Film title: ").append(title).append("\nRelease year: ").append(releaseYear)
					.append("\nRating: ").append(rating).append("\nDescription: ").append(description)
					.append("\nLanguage: " + language).append("\nActors: " + actors.toString()).append("\n\n");
		}
		return builder;

	}

	public StringBuilder getActorList() {
		return actorList;
	}

	public void setActorList(StringBuilder actorList) {
		this.actorList = actorList;
	}

	public StringBuilder actorsListedInFilm(List<Actor> actors) {
		StringBuilder builder = new StringBuilder();
		for (Actor actor : actors) {
			String firstName = actor.getFirstName();
			String lastName = actor.getLastName();
			builder.append("\t" + firstName + " " + lastName + "\n");
		}
		return builder;
	}

	public StringBuilder allMovieDetails() {
		StringBuilder builder = new StringBuilder();

		builder.append("Film ID: ").append(id).append("\nTitle: " + title).append("\nDescription: " + description)
				.append("\nRelease Year: " + releaseYear).append("\nLanguage ID: " + languageId)
				.append("\nRental Duration: " + rentalDuration).append("\nRental Rate: " + rentalRate)
				.append("\nLength: " + length).append("\nReplacement Cost: " + replacementCost)
				.append("\nRating: " + rating).append("\nSpecial Features: " + specialFeatures);
		return builder;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}
	
	public String retrieveCategories() {
		return null;
	}
}
