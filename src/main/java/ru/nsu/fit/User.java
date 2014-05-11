package ru.nsu.fit;

import javax.persistence.*;

/**
 * Created by Nikita on 10.05.2014.
 */

@Entity
@Table
public class User
{
	@Id
	private String name;

	public User(){}

	public User(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
