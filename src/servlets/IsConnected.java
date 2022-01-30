package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.User;

@WebServlet("") //index accessible même aux visiteurs simples
public class IsConnected extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static User connectedUser = null;
	private static HttpSession currentSession = null;
	private static List <Photo> photoPub;
	
	public User getConnectedUser(){
		return this.connectedUser;
	}
	
	public void setConnectedUser (User connectedUser){
		this.connectedUser = connectedUser;
	}
	
	public HttpSession getCurrentSession (){
		return this.currentSession;
	}
   
	public void setCurrentSession (HttpSession currentSession){
		this.currentSession = currentSession;
	}
	
	public List <Photo> getList (){
		List <Photo> pp = new ArrayList <Photo>;
		PhotoDao p =  new PhotoDao ();
		for (Photo f : p.getPub){
			pp.add(f);
		}
		if (this.connectedUser != null){
			for (Photo f : p.getPho(this.connectedUser)){//à adapter
				pp.add(f);
			}
		}	
		return pp;
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

	
	
