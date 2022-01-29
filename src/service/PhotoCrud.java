package service;

import java.io.InputStream;

import dao.PhotoDao;
 
public class PhotoCrud {
	public String createPhoto(String title,String description, String keywords, InputStream img, String nomAlb){
		String message = null;
		PhotoDao  p = new PhotoDao();
		String pth = "mesImages/" +nomPho+ ".jpg"; //ou png
		boolean created = p.add(title, pth, nomAlb); //les img sont stock�es dans un doc du projet et les chemins abs dans la bd
		boolean added = add(img);//methode � impl�menter pour mettre l'img dans le doc mesImages
		if (created && added)
			message = "La photo "+title + "a �t� cr��";
		return message;
	}
	
	public boolean add(InputStream img) {
		// TODO Auto-generated method stub
		return false;
	}

	public String readPhoto(Photo p) {
		DaoPhoto dp = new DaoPhoto();
		String path = dp.select(p.getId()); //à modifier
		return path;
	}
	
	public String updatePhoto(Photo p){
		DaoPhoto dp = new DaoPhoto();
	}
	
	public String deleteAlbum(Photo p){
		String message = null;
		DaoPhoto dp = new DaoPhoto();
		boolean deleted = dp.delete(p);
		if (deleted)
			message = "La photo a �t� supprim�";		
		return message;

	}
}
