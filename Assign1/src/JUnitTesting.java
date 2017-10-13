import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTesting {

	@Test
	public void Addtest() {
		char pick = 'a';
		Manager man = new Manager();
		boolean check = false;
		assertEquals(man.choose(pick), check);
		
	}
	
	@Test
	public void Removetest() {
		char pick = 'r';
		Manager man = new Manager();
		boolean check = false;
		assertEquals(man.choose(pick), check);
	}
	@Test
	public void Displaytest() {
		char pick = 'd';
		Manager man = new Manager();
		boolean check = false;
		assertEquals(man.choose(pick), check);
	}
	@Test
	public void Searchtest() {
		char pick = 's';
		Manager man = new Manager();
		boolean check = false;
		assertEquals(man.choose(pick), check);
	}
	@Test
	public void MovieTitleTest(){
		MovieMaker movie = new MovieMaker();
		movie.create();
		assertEquals(movie.getMovie().getName(), "happyfeet");
	}
	
	



}
