package runnable;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import connector.DbConnection;
import enum_.enum_frequency;
import enum_.enum_genere;
import model.Archive;
import model.Book;
import model.Catalogue;
import model.Magazine;
import model.Prestiti;
import model.Utente;

public class Runnable {
	
	
	
	public static void main(String[] args) {
		
		
		//<<<<<<<<<<<<<<<<<<<CREAZIONE TABELLE>>>>>>>>>>>>>>>>>>> 
//		Book book0 = new Book("bebo", enum_genere.FANTASY, "magari funziona", 2023, 50 );
//		Book book1 = new Book("bebo", enum_genere.DIVERTENTI, "magari non funziona", 2020, 150 );
//		Book book2 = new Book("bebo", enum_genere.CONTEMPORANEO, "forse funziona", 2013, 250 );
//		Book book3 = new Book("bebo", enum_genere.PRANORMALE, "credo funzioni", 2003, 530 );
//		
//		Magazine magazine1 = new Magazine(enum_frequency.MENSILE, "Sun", 2011, 50);
//		Magazine magazine2 = new Magazine(enum_frequency.ANNUALE, "gold", 2021, 60);
//		Magazine magazine3 = new Magazine(enum_frequency.SETTIMANALE, "corriere", 2023, 30);
//		Magazine magazine4 = new Magazine(enum_frequency.MENSILE, "bo", 1980, 34);
//		
//		
//		Utente utente = new Utente(10l,"Daniele","Fuccio", LocalDate.of(2002,9,14));
//		Utente utente1 = new Utente(12l,"Luca","Macis", LocalDate.of(1994,12,24));
//		Utente utente2 = new Utente(14l,"Kevin","Testi", LocalDate.of(2001,4,11));
		try {
			
//			Prestiti prestito1Utente = new Prestiti(utente,book0,LocalDate.of(2023,2,1),LocalDate.of(2023,4,4));
//			Prestiti prestito2Utente = new Prestiti(utente,magazine1,LocalDate.of(2023,2,10),LocalDate.of(2023,2,12));
//			
//			
//			Prestiti prestito1Utente1 = new Prestiti(utente1,book1,LocalDate.of(2023,2,2),LocalDate.of(2023,2,10));
//			Prestiti prestito2Utente1 = new Prestiti(utente1,magazine2,LocalDate.of(2023,2,15),LocalDate.of(2023,2,25));
//			
//			
//			Prestiti prestito1Utente2 = new Prestiti(utente2,book2,LocalDate.of(2023,2,3),null);
//			Prestiti prestito2Utente2 = new Prestiti(utente2,magazine3,LocalDate.of(2023,2,25),null);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN ELEMENTO AL DATABASE>>>>>>>>>>>>>>>>>>>
//			Catalogue.addToCat(book0);
//			Catalogue.addToCat(book1);
//			Catalogue.addToCat(book2);
//			Catalogue.addToCat(book3);
//			Catalogue.addToCat(magazine1);
//			Catalogue.addToCat( magazine2);
//			Catalogue.addToCat( magazine3);
//			Catalogue.addToCat( magazine4);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN UTENTE ALLA TABELLA>>>>>>>>>>>>>>>>>>>
//			Catalogue.addToUtente(utente);
//			Catalogue.addToUtente(utente1);
//			Catalogue.addToUtente(utente2);
			
			 //<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE PRESTITI ALLA TABELLA>>>>>>>>>>>>>>>>>>>
//			Catalogue.addToPrestiti(prestito1Utente);
//			Catalogue.addToPrestiti(prestito2Utente);
//			
//			Catalogue.addToPrestiti(prestito1Utente1);
//			Catalogue.addToPrestiti(prestito2Utente1);
//			
//			Catalogue.addToPrestiti(prestito1Utente2);
//			Catalogue.addToPrestiti(prestito2Utente2);
			
			
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTOPER ID>>>>>>>>>>>>>>>>>>>
			Catalogue.getById(4l);
			
			 //<<<<<<<<<<<<<<<<<<<METODO CHE ELIMINA UN ELEMENTO CERCATO PER ID>>>>>>>>>>>>>>>>>>>
//			Catalogue.delete(3l);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ANNO>>>>>>>>>>>>>>>>>>>
			List<Archive> archives = Catalogue.getByYear(2023);
			System.out.println("\nArchivi pubblicati nel 2023: " + archives);

			 //<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER AUTORE>>>>>>>>>>>>>>>>>>>
			
			List<Archive> ArchiveByAuthor = Catalogue.getByAuthor("bebo");
			System.out.println("\nLibri cercati per autore: " + ArchiveByAuthor);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER TITOLO>>>>>>>>>>>>>>>>>>>
			
			List<Archive> archiveByTitle = Catalogue.getByTitle("funz");
			System.out.println("\nLibri cercati per titolo: " + archiveByTitle);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN PRESTITO SCADUTO NON RESTITUITO>>>>>>>>>>>>>>>>>>>
			List<Prestiti> PrestitiScaduti = Catalogue.PrestitiScaduti();
			System.out.println("\n"+PrestitiScaduti);
			
			//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN PRESTITO NON SCADUTO PER N. TESSERA>>>>>>>>>>>>>>>>>>>
			List<Prestiti> Prestiticercati = Catalogue.getPrestitoById(10l);
			System.out.println(Prestiticercati);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
