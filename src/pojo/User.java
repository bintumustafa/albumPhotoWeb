package pojo;

import java.util.ArrayList;

public class User {
	private String prenom;
	private String nom;
	private String login;
	private String password;
	private String numero;
	private ArrayList<Photo> photoConcernees;
	
	public User(String prenom, String nom, String login, String password, String numero) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.numero = numero;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getProfil() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Photo> getPhotoConcernees() {
		return photoConcernees;
	}

	public void setPhotoConcernees(ArrayList<Photo> photoConcernees) {
		this.photoConcernees = photoConcernees;
	}
	
	
	

}
