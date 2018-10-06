package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.Books;

public class BooksTest {

	Books book;
	
	@Before
	public void setUp() {
		book = new Books();
	}
	
	@Test
	public void whenCallPodigniKnjiguStatusShouldBeFalse() {
		book.podigniKnjigu();
		assertFalse(book.getStatus());
	}
	
	@Test
	public void whenCallVratiKnjiguStatusShouldBeTrue() {
		book.vratiKnjigu();
		assertTrue(book.getStatus());
	}
	

}
