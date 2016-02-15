package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */

public class MovieService implements IFlix {
	
	List<Movie> movies = new ArrayList<Movie>();
	
	public MovieService() {
		super();
		movies.add(new Movie("Frozen","2013","English"));
		movies.add(new Movie("Star Wars","1983","English"));
		movies.add(new Movie("Mission Impossible","2009","English"));
		movies.add(new Movie("Mission: Impossible - Ghost Protocol","2011","English"));
		movies.add(new Movie("Mission: Impossible - Rogue Nation","2015","English"));
	}
	
	@Override
	public List<Movie> findAll() {
		return movies;
	}

	@Override
	public List<Movie> findByName(String name) {
		List<Movie> movieByName = new ArrayList<Movie>();
		
		for(Movie m : movies){
			if(m.getTitle().contains(name))
				movieByName.add(m);
		}
		
		return movieByName;
	}

	@Override
	public Movie create(Movie movie) {
		Movie m = new Movie();
		int count=0;
		Iterator<Movie> itr = movies.iterator();
		while(itr.hasNext()){
			m = itr.next();
			if(m.equals(movie)){
				break;
			}
			count++;
		}
		
		if(count==movies.size()){
			movies.add(movie);
		}
		
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		Movie m = new Movie();
		Iterator<Movie> itr = movies.iterator();
		while(itr.hasNext()){
			m = itr.next();
			if(m.equals(movie)){
				movie.setId(m.getId());
				return m;
			}
		}
		
		throw new NoSuchElementException();
	}

	@Override
	public Movie delete(String movie){
		
		Movie m = new Movie();
		Iterator<Movie> itr = movies.iterator();
		while(itr.hasNext()){
			m = itr.next();
			if(m.getTitle() == movie){
				itr.remove();
				return m;
			}
		}
		
		throw new NoSuchElementException();
	}

	@Override
	public boolean rentMovie(String movieTitle, String user) {
		Movie m = new Movie();
		Iterator<Movie> itr = movies.iterator();
		while(itr.hasNext()){
			m = itr.next();
			if(m.getTitle() == movieTitle && m.getRented()==false){
				m.setRented = true; 
				return true;
			}
		}
		return false;
	}

}
