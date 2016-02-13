package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	@Test
	public void testFindAll(){
		
		MovieService ms = new MovieService();
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Frozen","2013","English"));
		movies.add(new Movie("Star Wars","1983","English"));
		movies.add(new Movie("Mission Impossible","2009","English"));
		movies.add(new Movie("Mission: Impossible - Ghost Protocol","2011","English"));
		movies.add(new Movie("Mission: Impossible - Rogue Nation","2015","English"));
		
		List<Movie> moviesReturned = ms.findAll(); 
		
		Assert.assertEquals(movies,moviesReturned);
	}
	
	@Test
	public void testFindByName(){
		
		MovieService ms = new MovieService();
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Mission Impossible","2009","English"));
		movies.add(new Movie("Mission: Impossible - Ghost Protocol","2011","English"));
		movies.add(new Movie("Mission: Impossible - Rogue Nation","2015","English"));
		
		List<Movie> moviesReturned = ms.findByName("Mission"); 
		
		Assert.assertEquals(movies,moviesReturned);
	}
	
	@Test
	public void testCreate(){
		
		MovieService ms = new MovieService();
		Movie movie = new Movie("Mission: Impossible III","2000","English");
		Movie movieReturned = ms.create(movie);
	
		Assert.assertEquals(movie,movieReturned);
	}
	
	@Test
	public void testUpdate(){
		
		MovieService ms = new MovieService();
		Movie movie = new Movie("Mission: Impossible - Ghost Protocol","2011","English");
		Movie movieReturned = ms.update(movie);
	
		Assert.assertEquals(movie,movieReturned);		
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testUpdateMovieNotFound(){
		MovieService ms = new MovieService();
		Movie movie = new Movie("Mission: Impossible III","2000","English");
		ms.update(movie);
	}
	
	@Test
	public void testDelete(){
		
		MovieService ms = new MovieService();
		Movie movie = new Movie("Mission: Impossible III","2000","English");
		Movie movieReturned = ms.create(movie);
		movieReturned = ms.delete("Mission: Impossible III");
	
		Assert.assertEquals(movie,movieReturned);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testDeleteMovieNotFound(){
		MovieService ms = new MovieService();
		ms.delete("Mission: Impossible I");
	}
	
	@Test
	public void testRentMovie(){
		
		MovieService ms = new MovieService();
		boolean res = ms.rentMovie("Frozen", "Sruthi");
		
		Assert.assertEquals(true,res);
	}
}
