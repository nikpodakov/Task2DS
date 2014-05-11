package ru.nsu.fit;

import javax.persistence.*;

@Entity
@Table
public class Message
{
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Topic topic;

	@Column
	private String text;

	public Message() {}

	public Message(User user, Topic topic, String text)
	{
		this.user = user;
		this.topic = topic;
		this.text = text;
	}

	@Override
	public String toString()
	{
		return String.format("%s in %s wrote: \"%s\"", user, topic, text);
	}
}
