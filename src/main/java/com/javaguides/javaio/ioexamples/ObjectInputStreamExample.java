package com.javaguides.javaio.ioexamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInputStreamExample {
	public static void main(String[] args) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.txt"))) {
			final Employee employee = (Employee) in.readObject();
			System.out.println(" printing employee object details");
			System.out.println(employee.getId() + " " + employee.getName());
			System.out.println(" printing address object details");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
