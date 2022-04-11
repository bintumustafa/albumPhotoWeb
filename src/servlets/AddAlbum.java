package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Album;
import pojo.User;
import service.AlbumCrud;

/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/AddAlbum")
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addAlbum.jsp").forward(request, response); //selon le nom de jsp que Amina aura mis
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomAlb = request.getParameter("nomAlb");
		AlbumCrud alb = new AlbumCrud();
    		HttpSession session = request.getSession();
		String nom = (String) session.getAttribute("nomUser");
		String login = (String) session.getAttribute("loginUser");
		String password = (String) session.getAttribute("passwordUser");
		String profil = (String) session.getAttribute("profil");
		//User userOwner = new User(login, password, nom, profil);
		Album a = new Album(nomAlb);
		alb.createAlbum(a, login);
	}
	
	protected void generateResp(HttpServletResponse reponse) throws IOException {
		   //creation de la reponse
		   StringBuffer resp = new StringBuffer();
		   resp.append("<HTML>\n");
		   resp.append("<HEAD></HEAD>\n");
		   resp.append("<BODY>\n");
		   //recuperer le msg de alb créé
		   resp.append("</BODY>\n");
		   resp.append("</HTML>");
		   
		   //en-t�te
		   reponse.setContentType("text/html");
		   reponse.setContentLength(resp.length());
		   
		   //envoi r�ponse
		   reponse.getOutputStream().print(resp.toString());
		}

}
