package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import library.Account;
import library.Books;

public class Biblioteka {

	static Scanner input = new Scanner(System.in);
	static Scanner stringInput = new Scanner(System.in);
	static ArrayList<Account> users = new ArrayList<>();
	static ArrayList<Books> books = new ArrayList<>();

	public static double isDouble() { // handle exception za double brojeve
		while (true) {
			try {
				return input.nextDouble();
			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Vas unos nije dobar. Probajte ponovo: ");
			}
		}
	}

	public static int isInteger() { // handle exception za integer brojeve
		while (true) {
			try {
				return input.nextInt();
			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Vas unos nije dobar. Probajte ponovo: ");
			}
		}
	}
	
	public static String isString() { // handle exception za String
		while (true) {
			try {
				return stringInput.nextLine();
			} catch (InputMismatchException e) {
				stringInput.next();
				System.out.println("Vas unos nije dobar. Probajte ponovo: ");
			}
		}
	}

	public static boolean existUser(int id) {
		boolean exist = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public static boolean existBook(int id) {
		boolean exist = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookId() == id) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public static void main(String[] args) throws Exception {

		int opcija;
		Account account;
		Books book;
		int idKorisnika = 0;
		int idKnjige = 0;

		do {
			System.out.println(
					"1 - Registracija korisnika, \n2 - Registracija knjige, \n3 - Informacije o korisniku, \n4 - Informacije o knjizi, \n5 - Podigni knjigu, \n6 - Vrati knjigu, \n7 - Ispis knjiga koje su dostupne, \n8 - Iprintaj informacije o korisniku, \n9 - Isprintaj informacije o knjizi, \n0 - Izlaz \nIzaberite opciju: ");
			opcija = isInteger();

			switch (opcija) {
			case 0:
				break;
			case 1:
				do {
					account = new Account();
				} while (existUser(account.getId()));
				System.out.println("Vas ID je: " + account.getId());
				System.out.print("Upisite vase ime: ");
				String ime = isString();
				account.setName(ime);
				users.add(account);
				break;
			case 2:
				do {
					book = new Books();
				} while (existBook(book.getBookId()));
				System.out.println("Id knjige je: " + book.getBookId());
				System.out.print("Unesit ime knjige: ");
				String imeKnjige = isString();
				
				book.setBookName(imeKnjige);
				books.add(book);
				break;
			case 3:
				do {
					System.out.println("Upiste ID korisnika cije informacije zelite vidjeti: ");
					idKorisnika = isInteger();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId() == idKorisnika) {
						users.get(i).info();
					}
				}
				break;
			case 4:
				do {
					System.out.println("Upisite ID knjige cije informacije zelite vidjeti: ");
					idKnjige = isInteger();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getBookId() == idKnjige) {
						books.get(i).info();
					}
				}
				break;
			case 5:
				do {
					System.out.println("Upiste ID korisnika koji podize knjigu: ");
					idKorisnika = isInteger();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				do {
					System.out.println("Upisite ID knjige koju korisnik dize: ");
					idKnjige = isInteger();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getBookId() == idKnjige) {
						Books knjigaZaPodizanje = books.get(i);
						if (knjigaZaPodizanje.getStatus() == true) {
							knjigaZaPodizanje.podigniKnjigu();
							for (int j = 0; j < users.size(); j++) {
								if (users.get(j).getId() == idKorisnika) {
									Account korisnikKojiPodizeKjigu = users.get(j);
									korisnikKojiPodizeKjigu.povecajBrojPosudjenjihKnjiga();
								}
							}
						} else {
							System.out.println("Knjiga je vec podignuta!");
						}
					}
				}
				break;

			case 6:
				do {
					System.out.println("Upiste ID korisnika koji vraca knjigu: ");
					idKorisnika = isInteger();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				do {
					System.out.println("Upisite ID knjige koju korisnik vraca: ");
					idKnjige = isInteger();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getBookId() == idKnjige) {
						Books knjigaZaVracanje = books.get(i);
						if (knjigaZaVracanje.getStatus() == false) {
							knjigaZaVracanje.vratiKnjigu();
							for (int j = 0; j < users.size(); j++) {
								if (users.get(j).getId() == idKorisnika) {
									Account korisnikKojiVracaKnjigu = users.get(j);
									korisnikKojiVracaKnjigu.smanjiBrojPosudjenihKnjiga();
								}
							}
						} else {
							System.out.println("Knjiga nije podignuta!");
						}
					}
				}
				break;
			case 7:
				System.out.println("Knjige koje su dostupne: ");
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getStatus() == true)
					System.out.println(books.get(i).getBookId() + " " + books.get(i).getBookName());
				}
				break;
			case 8: 
				do {
					System.out.println("Upiste ID korisnika cije informacije zelite isprintati: ");
					idKorisnika = isInteger();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId() == idKorisnika) {
						try {
							users.get(i).ispisInformacijaOKorisniku();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						};
					}
				}
				break;
			case 9: 
				do {
					System.out.println("Upiste ID knjige cije informacije zelite isprintati: ");
					idKnjige = isInteger();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getBookId() == idKnjige) {
						try {
							books.get(i).ispisInformacijaOKnjizi();
							} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						};
					}
				}
				break;
			default: 
				System.out.println("Unos opcije nije dobar.");
			}
			
				

		} while (opcija != 0);

	}
}
