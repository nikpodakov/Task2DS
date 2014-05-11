package ru.nsu.fit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("H2PersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		fillDB(manager);
		manager.getTransaction().commit();
		printDB(manager);
		manager.close();
	}

	private static void fillDB(EntityManager manager)
	{
		User[] users = new User[]
				{
						new User("user1"),
						new User("user2")
				};
		for(User user : users)
		{
			manager.persist(user);
		}
		Admin admin = new Admin("user3");
		manager.persist(admin);
		Topic[] topics = new Topic[]
				{
						new Topic("User1Topic1", users[0]),
						new Topic("User1Topic2", users[0]),
						new Topic("User2Topic1", users[1]),
						new Topic("User3Topic1", admin)
				};
		for(Topic topic : topics)
		{
			manager.persist(topic);
		}
		Message[] messages = new Message[]
				{
						new Message(users[0], topics[0], "User1Topic1Message1"),
						new Message(users[0], topics[0], "User1Topic1Message2"),
						new Message(users[1], topics[0], "User2Topic1Message1"),
						new Message(admin, topics[0], "User3Topic1Message1"),
						new Message(users[0], topics[1], "User1Topic2Message1"),
						new Message(admin, topics[1], "User3Topic2Message1"),
						new Message(users[0], topics[2], "User1Topic3Message1"),
						new Message(users[1], topics[2], "User2Topic3Message1")
				};
		for(Message message : messages)
		{
			manager.persist(message);
		}
	}

	private static void printDB(EntityManager manager)
	{
		System.out.println("Users:");
		for( Object objectUser : manager.createQuery("SELECT user from User user").getResultList() ) {
			User user = (User) objectUser;
			System.out.println(user);
		}
		System.out.println();
		System.out.println("Topics:");
		for( Object objectTopic : manager.createQuery("SELECT topic from Topic topic").getResultList() ) {
			Topic topic = (Topic) objectTopic;
			System.out.println(topic);
		}
		System.out.println();
		System.out.println("Messages:");
		for( Object objectMessage : manager.createQuery("SELECT message from Message message").getResultList() ) {
			Message message = (Message) objectMessage;
			System.out.println(message);
		}
	}
}