package com.skilldistillery.filmquery.entities;

import java.util.List;

public class FilmInventory {
	private int id;
	private int filmId;
	private int storeId;
	private String mediaCondition;
	private String lastUpdate;
	
	public FilmInventory(int id, int filmId, int storeId, String mediaCondition, String lastUpdate) {
		super();
		this.id = id;
		this.filmId = filmId;
		this.storeId = storeId;
		this.mediaCondition = mediaCondition;
		this.lastUpdate = lastUpdate;
	}
	
	public FilmInventory() {
	}

	public StringBuilder filmInventoryPrinter(List<FilmInventory> fi) {
		StringBuilder builder = new StringBuilder();
		for (FilmInventory filmInventory : fi) {
			int id = filmInventory.getId();
			int filmId = filmInventory.getFilmId();
			int storeId = filmInventory.getStoreId();
			String mediaCondition = filmInventory.getMediaCondition();
			String lastUpdate = filmInventory.getLastUpdate();
			
			builder.append("Inventory ID number: ").append(id).append("\nFilm ID: ").append(filmId).append("\nStore ID: ")
			.append(storeId).append("\nMedia Condition: ").append(mediaCondition).append("\nLast Update: ").append(lastUpdate).append("\n\n");
		}
		
		return builder;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + filmId;
		result = prime * result + id;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((mediaCondition == null) ? 0 : mediaCondition.hashCode());
		result = prime * result + storeId;
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
		FilmInventory other = (FilmInventory) obj;
		if (filmId != other.filmId)
			return false;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (mediaCondition == null) {
			if (other.mediaCondition != null)
				return false;
		} else if (!mediaCondition.equals(other.mediaCondition))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}

}
