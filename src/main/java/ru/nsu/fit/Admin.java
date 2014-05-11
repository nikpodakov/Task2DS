package ru.nsu.fit;

import javax.persistence.Entity;

@Entity
public class Admin extends User
{
	public Admin(){}

	public Admin(String name)
	{
		super(name);
	}

	@Override
	public String toString()
	{
		return super.toString() + "(Admin)";
	}
}