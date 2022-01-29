package service;

import dao.User; //ï¿½ changer selon le nom du package et de la classe que cheikh aura mis
import dao.UserDao;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpSession;

public class SessionService implements Serializable{
	private String login;
	private String password;
	private User connectedUser;
	//private Object setConnectedUser;
	//private Object getConnectedUser;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin (String login){
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword (String password){
		this.password = password;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public String signIn() throws IOException{
		String redirect = null;
		UserDao auth = new UserDao();//ï¿½ adapter au nom de la classe dans le modï¿½le
	    boolean isConnected = auth.verifyLogin(this.login, this.password);//on suppose que la methode est boolean
	    if(isConnected){
	    	this.connectedUser = auth.select(this.login, this.password);//demander à cheikh d'implémenter ca
	    	String profil = this.getConnectedUser().getProfil();//profil={simple,admin,root} 
	    	if (profil.equals("simple"))
	    		redirect = "indexSimple.jsp";
	    	else
	    		redirect = "indexAdmin.jsp";
	    	Loader l = new Loader();
	    	boolean loaded = l.load(this.connectedUser); //pour charger les images de la bd vers le server d'appli
	    }
    	else {//onn affiche au niveau de la console juste pour faire des tests
    		System.out.println("Login et/ou mot de passe incorrect(s)");
    		this.setConnectedUser(null);
    		
	    	} 	    
	    return redirect;
	}
	
	public void signOut(){
		this.setConnectedUser(null);
		
	}
}
