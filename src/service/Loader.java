package service;

import pojo.Photo; //� changer selon le nom du package et de la classe que cheikh aura mis
import pojo.User;
import dao.*;

import java.io.File;
import java.io.IOException;

public class Loader{
	public boolean load(User connectedUser) throws IOException{
		//ici on doit prendre les photos qui concernent le user connect� de la bd pour les 
		//charger dans un rep temp du server appli pour �viter les va et vient
		//lesPhotosconcern�es ={user's photos, photos publiques, photos qui lui sont partag�es}
		boolean loaded = false;
		Photo [] lesPhotosConcernees = (Photo[]) connectedUser.downloadImages(); //on suppose qu'il existe une m�thode qui permet de recup�rer les chemins abs img de la bd
															//si en une structure autre que tab comme list ou autre on changera
		int len = lesPhotosConcernees.length;
		if (len > 0){
			for (int i = 0; i < len; i++ ){//pour chaque img on cr�e un fichier dans le rep temp
				String imgtempPath = lesPhotosConcernees[i].getPath(); 
				//string imgtempname = "img"+Integer.toString(i);;
				File f = File.createTempFile("tmp", null, new File(imgtempPath));
				f.deleteOnExit();
			}
			loaded = true;
			
		}
		return loaded;
		
	}
	
	public boolean unload(){
		boolean unloaded = false;
		File[] lesPhotosConcernees = new File("/Users/aida/Desktop/sbs/apache-tomcat-9.0.55/temp").listFiles();
		for (File file : lesPhotosConcernees) {
			file.deleteOnExit();
		}
		return unloaded;
		
	}
}