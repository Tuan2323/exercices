package fr.afpa.exercices;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.afpa.exercices.config.AppConfig;
import fr.afpa.exercices.model.Books;
import fr.afpa.exercices.spring.jdbc.BooksDAO;
import lombok.extern.log4j.Log4j;


@Log4j
public class Main
{
 public static void main( String[] args )
 {
	// Creating a Context Application object by reading
			// the configuration of the 'AppConfiguration' class.
			ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
			
			//CustomerDao customer= (CustomerDao) ctx.getBean("customerDao");
			//customer.createTable();
			
			log.info("list des livres");
			BooksDAO bdao = (BooksDAO) ctx.getBean("booksDAO");
			
			List<Books> books = bdao.getAllBooks();
			for (Books book : books) {
				System.out.println(books);
			}
			
			log.info("nombres des commentaires");
			System.out.println(bdao.getNbBooks());
			
			log.info("afficher auteur");
		System.out.println(bdao.affauthor());
		
			
			log.info("delet commentaires");

			bdao.SupprLivre();
	
		}

	}
