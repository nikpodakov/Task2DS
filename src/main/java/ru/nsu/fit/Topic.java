package ru.nsu.fit;

import javax.persistence.*;

@Entity
@Table
public class Topic
{
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String title;

	@ManyToOne
	private User user;
	public Topic() {}

	public Topic(String title, User user){
		this.title = title;
		this.user = user;
	}

	@Override
	public String toString()
	{
		return String.format("Topic \"%s\" by \"%s\"", title, user);
	}
}
