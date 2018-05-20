package io.github.ashayking.model;

import lombok.Data;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Data
public class Manager {

	private int id;
	private String name;
	private Employee personalAssistant;

	public Manager() {

	}

	public Manager(String name) {
		this.name = name;
	}
}
