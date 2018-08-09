
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

}
