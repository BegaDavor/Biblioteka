
public class Account {

	// Atributi

	private int id = (int) (Math.random() * 100000);
	private String name;
	private int brojPosudjenihKnjiga = 0;

	// Konstruktor

	public Account() {
		// TODO Auto-generated constructor stub
	}

	// getters

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBrojPosudjenihKnjiga() {
		return brojPosudjenihKnjiga;
	}

	// setters

	public void setName(String name) {
		this.name = name;
	}

	// metode

	public void povecajBrojPosudjenjihKnjiga() {
		if (this.brojPosudjenihKnjiga < 3)
			this.brojPosudjenihKnjiga += 1;
		else
			System.out.println("Mozete podici samo tri knjige.");
	}
	
	public void smanjiBrojPosudjenihKnjiga() {
		if (this.brojPosudjenihKnjiga > 0)
			this.brojPosudjenihKnjiga -= 1;
		else
			System.out.println("Nemate posudjenih knjiga.");
	}
	
	public void info() {
		System.out.println("ID: " + getId());
		System.out.println("Ime: " + getName());
		System.out.println("Broj posudjenih knjiga: " + getBrojPosudjenihKnjiga());
	}

}
