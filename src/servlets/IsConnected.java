package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoPhoto;
import dao.DaoUser;
import pojo.Photo;
import pojo.User;

@WebServlet("") //index accessible même aux visiteurs simples
public class IsConnected extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static User connectedUser = null;
	private static HttpSession currentSession = null;
	private static List <Photo> listPhoto;
	
	public static User getConnectedUser(){
		return IsConnected.connectedUser;
	}
	
	public static void setConnectedUser (User connectedUser){
		IsConnected.connectedUser = connectedUser;
	}
	
	public static HttpSession getCurrentSession (){
		return IsConnected.currentSession;
	}
   
	public static void setCurrentSession (HttpSession currentSession){
		IsConnected.currentSession = currentSession;
	}
	
	public static List <Photo> getListPhoto (){
		//List <Photo> pp = new ArrayList <Photo> ();
		DaoPhoto p =  new DaoPhoto ();
		for (Photo f : p.getPub()){
			IsConnected.listPhoto.add(f);
		}
		if (IsConnected.connectedUser != null){
			for (Photo f : p.getPho(IsConnected.connectedUser)){//à adapter
				listPhoto.add(f);
			}
		}	
		return IsConnected.listPhoto;
	}
	
	//public List <Photo> 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsConnected() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("indexPublic.jsp").forward(request, response); //selon le nom de jsp que Amina aura mis
	}
}

	
	
