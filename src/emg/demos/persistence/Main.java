package emg.demos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import emg.demos.persistence.model.single.Todo;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		System.out.println("*************************************");
		System.out.println("Single Table Example");
		System.out.println("*************************************");
		
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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
		
		System.out.println("*************************************");
		System.out.println("Relationship Example");
		System.out.println("*************************************");
		
		
	}
}
