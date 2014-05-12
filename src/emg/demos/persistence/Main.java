package emg.demos.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import emg.demos.persistence.model.bookstore.Address;
import emg.demos.persistence.model.bookstore.Book;
import emg.demos.persistence.model.bookstore.Customer;
import emg.demos.persistence.model.bookstore.compositekeys.News;
import emg.demos.persistence.model.bookstore.compositekeys.NewsId;
import emg.demos.persistence.model.bookstore.enumerated.CreditCard;
import emg.demos.persistence.model.bookstore.enumerated.CreditCardType;
import emg.demos.persistence.model.single.Todo;

public class Main {
	//private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;
	
	private static void runSingle (String persistenceUnitName) {
		System.out.println("*************************************");
		System.out.println("Single Table Example");
		System.out.println("*************************************");
		
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = factory.createEntityManager();
		// create new todo
		em.getTransaction().begin();
		
		Todo todo = new Todo();
		todo.setSummary("This is a test");
		todo.setDescription("This is a test");
		em.persist(todo);
		em.getTransaction().commit();
		// read using Query
		// Query q = em.createQuery("select t from Todo t");
		// read using NamedQuery
		Query q = em.createNamedQuery("findAllTodos");
		List<Todo> todoList = q.getResultList();
		for (Todo item : todoList) {
			System.out.println(item);
		}
		System.out.println("Size: " + todoList.size());
		em.close();
		factory.close();
	}

	private static void runBookStore (String persistenceUnitName) {
		System.out.println("*************************************");
		System.out.println("BookStore Example");
		System.out.println("*************************************");
		
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("Creating Book");
		Book book = new Book();
		book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("SiFi");
        tags.add("Comedy");
        tags.add("Guide");
        book.setTags(tags);
        em.persist(book);
        //em.getTransaction().commit();
        
        System.out.println("Creating News");
        NewsId nid = new NewsId();
        nid.setLanguage("JP");
        nid.setTitle("shichi nin no samurai");
        News news = new News();
        news.setId(nid);
        news.setContent("Old Japanese movie");
        em.persist(news);
        
        System.out.println("Creating Credit Card");
        CreditCard creditCard = new CreditCard();
        creditCard.setControlNumber(123);
        creditCard.setType(CreditCardType.VISA);
        creditCard.setNumber("2342-1243-9878-0988");
        creditCard.setExpiryDate("01/15");
        em.persist(creditCard);
        
        System.out.println("Creating Customer");
        Customer customer = new Customer("Edison", "Martinez", "email@none.com", "0987654321", new Date(), new Date());
        Address address = new Address();
        address.setCity("UIO");
        address.setCountry("EC");
        address.setState("PI");
        address.setStreet1("Principal");
        address.setStreet2("la que cruza");
        address.setZipcode("EC170530");
        customer.setAddress(address);
        em.persist(customer);
        
        em.getTransaction().commit();
        em.close();
        factory.close();
	}
	
	public static void main(String[] args) {
		//runSingle("todos");
		runBookStore("bookstore");
	}
}
