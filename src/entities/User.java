package entities;

import exceptions.StringNotValidException;

public class User {
	private String name;
	private String surname;

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws StringNotValidException {
		// Throws è l'alternativa che abbiamo al try-catch. Serve per informare il chiamante
		// (chi invoca il metodo) che il metodo potrebbe in alcune situazioni lanciare questa eccezione
		// CHECKED. E' un po' come delegare la gestione del problema a chi chiama il metodo
		if (name.length() < 3) throw new StringNotValidException(name);
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}
}
