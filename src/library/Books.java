package library;

import java.io.File;
import java.io.PrintWriter;

public class Books {

	// Atributi

	private int bookId = (int) (Math.random() * 100000);
	private String bookName;
	private boolean status = true;

	// Konstruktor

	public Books() {
		// TODO Auto-generated constructor stub
	}

	// getters

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public boolean getStatus() {
		return status;
	}

	// setters

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// metode

	public void podigniKnjigu() {
		setStatus(false);
	}

	public void vratiKnjigu() {
		setStatus(true);
	}

	public void info() {
		System.out.println("ID knjige: " + getBookId());
		System.out.println("Ime knjige: " + getBookName());
		if (getStatus() == true) {
			System.out.println("Knjiga je dostupna.");
		} else {
			System.out.println("Knjiga nije dostupna.");
		}
	}
	
	public void ispisInformacijaOKnjizi() throws Exception{
		File knjiga = new File("InfoKnjiga");
		PrintWriter output = new PrintWriter(knjiga);
		output.println("Informacije o knjizi");
		output.println("--------------------------");
		output.println("ID: " + getBookId());
		output.println("Ime: " + getBookName());
		if (getStatus() == true) {
			output.println("Knjiga je dostupna.");
		} else {
			output.println("Knjiga nije dostupna.");
		}
		output.close();
	}

}
