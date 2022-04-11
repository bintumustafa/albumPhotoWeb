package service;

import java.io.InputStream;

import dao.DaoPhoto;
import pojo.Album;
import pojo.Photo;
 
public class PhotoCrud {
	public String createPhoto(String title,String description, String keywords, InputStream img, Album nomAlb){
		String message = null;
		DaoPhoto  p = new DaoPhoto();
		String pth = "mesImages/" +title+ ".jpg"; //ou png
		boolean created = p.add(title, pth, nomAlb); //les img sont stock�es dans un doc du projet et les chemins abs dans la bd
		boolean added = add(img);//methode � impl�menter pour mettre l'img dans le doc mesImages
		if (created && added)
			message = "La photo "+title + "a �t� cr��e";
		return message;
	}
	
	public boolean add(InputStream img) {
		// TODO Auto-generated method stub
		return false;
	}

	public String readPhoto(String idPhoto) {
		DaoPhoto dp = new DaoPhoto();
		String path = dp.select(idPhoto); //à modifier
		return path;
	}
	
	public String updatePhoto(Photo p){
		String message = null;
		DaoPhoto dp = new DaoPhoto();
		
		return message;
	}
	
	public String deleteAlbum(Photo p){
		String message = null;
		DaoPhoto dp = new DaoPhoto();
		boolean deleted = dp.delete(p);
		if (deleted)
			message = "La photo a �t� supprim�e";		
		return message;

	}
}
