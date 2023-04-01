package model;

import java.sql.SQLException;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import connector.DbConnection;


public class Catalogue {

	static EntityManager em = DbConnection.getEntityManagerFactory().createEntityManager();


  //<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN ARCHIVIO ALLA TABELLA>>>>>>>>>>>>>>>>>>>
    public static void addToCat(Archive a)  throws SQLException {
    	em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		System.out.println("elemento salvato nel database");
    }
    
	//<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE UN UTENTE ALLA TABELLA>>>>>>>>>>>>>>>>>>>
    public static void addToUtente(Utente u)  throws SQLException {
    	em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente salvato nel database");
    }
    
    //<<<<<<<<<<<<<<<<<<<METODO CHE AGGIUNGE PRESTITI ALLA TABELLA>>>>>>>>>>>>>>>>>>>
    public static void addToPrestiti(Prestiti p)  throws SQLException {
    	em.getTransaction().begin();
    	em.persist(p);
    	em.getTransaction().commit();
    	System.out.println("Prestiti salvato nel database");
    }

  //<<<<<<<<<<<<<<<<<<<METODO CHE ELIMINA UN ELEMENTO CERCATO PER ID>>>>>>>>>>>>>>>>>>>
    public static void delete(Long iSBNcode) throws SQLException {
		em.getTransaction().begin();
		Archive e = em.find(Archive.class, iSBNcode);
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Utente eliminato nel database");
	}

  //<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ID>>>>>>>>>>>>>>>>>>>
    public static Archive getById(Long iSBNcode) throws SQLException {
  		em.getTransaction().begin();
  		Archive e = em.find(Archive.class, iSBNcode);
  		em.getTransaction().commit();
  		System.out.println(e);
  		return e;
  	}
    
 // <<<<<<<<<<<<<<<<<<<<<<<<<< MODIFICA EVENTO >>>>>>>>>>>>>>>>>>>>>>>>>>
 	public static void updateEvento(Archive e) throws SQLException {
 			em.getTransaction().begin();
 			em.merge(e);
 			em.getTransaction().commit();
 			System.out.println("Utente modificato nel database");
 			System.out.println(e);
 		}

  //<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER ANNO>>>>>>>>>>>>>>>>>>>
 	public static List<Archive> getByYear(int anno) throws SQLException{
 	    List<Archive> resultList = em.createNamedQuery("Archive.findByYear", Archive.class)
 	            .setParameter("anno", anno)
 	            .getResultList();
 	    return resultList;
 	}

  //<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER AUTORE>>>>>>>>>>>>>>>>>>>
 	public static List<Archive> getByAuthor(String author)throws SQLException {
 	    Query query = em.createNamedQuery("Archive.findByAuthor", Archive.class);
 	    query.setParameter("author", author);
 	    return query.getResultList();
 	}
 	
 	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN ELEMENTO PER TITOLO>>>>>>>>>>>>>>>>>>>
 	public static List<Archive> getByTitle(String titolo)throws SQLException {
 		Query query = em.createNamedQuery("Archive.findByTitle");
 		query.setParameter("titolo", titolo);
 		return query.getResultList();
 	}
 	
 	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN PRESTITO NON SCADUTO PER N. TESSERA>>>>>>>>>>>>>>>>>>>
 	 public static List<Prestiti> getPrestitoById(Long tessera) throws SQLException {
 		Query query = em.createNamedQuery("Prestiti.findByTessera");
 		query.setParameter("tessera", tessera);
   		return query.getResultList();
   	}
 	
 	//<<<<<<<<<<<<<<<<<<<METODO CHE CERCA UN PRESTITO SCADUTO NON RESTITUITO>>>>>>>>>>>>>>>>>>>
 	public static   List<Prestiti> PrestitiScaduti() throws SQLException {
 		Query query = em.createNamedQuery("Prestiti.prestitiScaduti");
 		return query.getResultList();
 	}
}