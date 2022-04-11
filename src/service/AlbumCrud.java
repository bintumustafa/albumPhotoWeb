package service;

import dao.DaoAlbum;//cette classe impl�mente des req sur la table album
import dao.DaoPhoto;
import pojo.Album;

public class AlbumCrud {
	public String createAlbum(Album alb, String currentLog){
		String message = null;
		DaoAlbum a = new DaoAlbum();
		boolean created = a.insert(alb, currentLog);//cette m�thode du mod�le doit insert les diff champs de alb et le log du createur comme cl� �trang�re
		if (created)
			message = "L'album "+alb.getNomAlb() + "a �t� cr��";
		return message;
	}
	
	public String [] readAlbum (String nomAlb) {
		DaoPhoto p = new DaoPhoto();
		String [] alb =  p.selectAlb(nomAlb); //req sur table photo where alb = nomAlb donne les chemins abs des img
		return alb;
	}
	
	public String updateAlbum (String nomAlb){//chaque nomAlb est unique et ici on change juste le niveau de restriction de l'album
		String message = null;
		DaoAlbum a = new DaoAlbum();
		boolean updated = a.updateRest(nomAlb);
		if (updated)
			message = "Vous avez modifi� le niveau de visibilit� de l'album"+ nomAlb;	
		return message;
	}
	
	public String deleteAlbum (String nomAbl){
		String message = null;
		DaoAlbum a = new DaoAlbum();
		boolean deleted = a.delete(nomAbl);//on supprime d'abord toutes les tuples de la table photo where alb = nomAlb
		if (deleted)
			message = "L'album "+ nomAbl +"a �t� supprim�";		
		return message;
	}
}
