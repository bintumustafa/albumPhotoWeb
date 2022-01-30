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
import service.PhotoCrud;

/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/addPhoto")
public class AddPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add.jsp").forward(request, response); //selon le nom de jsp que Amina aura mis
	}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomAlb = request.getParameter("nomAlb");
		AlbumCrud alb = new AlbumCrud();
    HttpSession session = request.getSession();
		String title = (String) session.getAttribute("tite");
		String description = (String) session.getAttribute("description");
		String keywords = (String) session.getAttribute("keywords");
		String album = (String) session.getAttribute("album");
		//User userOwner = new User(login, password, nom, profil);
		PhotoCrud p = new PhotoCrud();
		p.createPhoto(title, description, keywords, album);
	}
