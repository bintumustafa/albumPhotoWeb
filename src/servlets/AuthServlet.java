package servlets;

import dao.User; //ï¿½ changer selon le nom du package et de la classe que cheikh aura mis
//import dao.Authentification; //idem
import service.Loader; // ï¿½ implï¿½menter dans le package service
import service.SessionService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signin")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("authentification.jsp").forward(request, response); //selon le nom de jsp que Amina aura mis
		//l'url signin permet d'accï¿½der ï¿½ la page d'authentification
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//on soumet la l'authenfication avec la mï¿½thode post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupï¿½ration des paramï¿½tres de connexion
		String login = request.getParameter("loginUser");
    	String password = request.getParameter("passwordUser");
    	SessionService sess = new SessionService();
    	sess.setLogin(login);
    	sess.setPassword(password);
    	String redirect = sess.signIn();
    	if (sess.getConnectedUser() != null ){
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser", login);
	    	session.setAttribute("passwordUser", password);
	    	session.setAttribute("nomUser", sess.getConnectedUser().getNom());
	    	session.setAttribute("profil", sess.getConnectedUser().getProfil());//profil={simple,admin,root}
		IsConnected.setCurrentSession(session);
		IsConnected.setConnectedUser(sess.getConnectedUser());
	    	Loader ld = new Loader();
	    	boolean loaded = ld.load(IsConnected.getList()); //pour charger les images de la bd vers le server d'appli
	    	request.getRequestDispatcher(redirect).forward(request, response); //on le redirige vers sa page d'accueil  
	    	}
	    	else {//onn affiche au niveau de la console juste pour faire des tests
	    		System.out.println("Login et/ou mot de passe incorrect(s)");
	    		generateResp(response);
	    		response.sendRedirect("signin");
	    	} 	
	}
	
	protected void generateResp(HttpServletResponse reponse) throws IOException {
	   //creation de la reponse
	   StringBuffer resp = new StringBuffer();
	   resp.append("<HTML>\n");
	   resp.append("<HEAD></HEAD>\n");
	   resp.append("<BODY>\n");
	   resp.append("<H1>Login et/ou mot de passe incorrect(s)</H1>\n");
	   resp.append("</BODY>\n");
	   resp.append("</HTML>");
	   
	   //en-tï¿½te
	   reponse.setContentType("text/html");
	   reponse.setContentLength(resp.length());
	   
	   //envoi rï¿½ponse
	   reponse.getOutputStream().print(resp.toString());
	}
   

}

