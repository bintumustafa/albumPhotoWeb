package service;

import java.io.InputStream;

import dao.DaoPhoto;
 
public class PhotoCrud {
	public String createPhoto(String nomPho, InputStream img, String nomAlb){
		String message = null;
		DaoPhoto p = new DaoPhoto();
		String pth = "mesImages/" +nomPho;
		boolean created = p.insert(nomPho, pth, nomAlb); //les img sont stock�es dans un doc du projet et les chemins abs dans la bd
		boolean added = add(img);//methode � impl�menter pour mettre l'img dans le doc mesImages
		if (created && added)
			message = "La photo "+nomPho + "a �t� cr��";
		return message;
	}
	
	public boolean add(InputStream img) {
		// TODO Auto-generated method stub
		return false;
	}

	public String readPhoto(String nomPho) {
		DaoPhoto p = new DaoPhoto();
		String path =p.select(nomPho);
		return path;
	}
}