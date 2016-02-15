package io.egen.rentalflix;

import java.util.UUID;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	//POJO IMPLEMENTATION GOES HERE
	
	private String id;
	private String title;
	private String year;
	private String language;
	private boolean rented;
	public boolean setRented;
	
	public Movie(){
		
	}
	
	public Movie(String title, String year, String language) {
		super();
		UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		this.id = uid.randomUUID().toString();
		this.title = title;
		this.year = year;
		this.language = language;
		this.rented = false;
	}
	
	public Movie(String id,String title, String year, String language) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.language = language;
		this.rented = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public boolean getRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		/*if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;*/
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
}
