package service;

import pojo.Photo; //� changer selon le nom du package et de la classe que cheikh aura mis
import pojo.User;
import dao.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Loader{
	public boolean load(List <Photo> lesPhotosConcernees) throws IOException{
		//ici on doit prendre les photos qui concernent le user connect� de la bd pour les 
		//charger dans un rep temp du server appli pour �viter les va et vient
		//lesPhotosconcern�es ={user's photos, photos publiques, photos qui lui sont partag�es}
		boolean loaded = false;															 
		int siz = lesPhotosConcernees.size();
		if (siz > 0){
			for (int i = 0; i < siz; i++ ){//pour chaque img on cr�e un fichier dans le rep temp
				String imgtempPath = lesPhotosConcernees.get(i).getPath(); 
				String imgTemp = lesPhotosConcernees.get(i).getTitle();
				File f = File.createTempFile(imgTemp, null, new File(imgtempPath));
				f.deleteOnExit();
			}
			loaded = true;
			
		}
		return loaded;
		
	}
	
	public boolean unload(){
		boolean unloaded = false;
		File [] f = new File("C:\\Users\\Administrateur\\Desktop\\envJava\\apache-tomcat-9.0.55\\temp").listFiles();
		for (File file : f) 
			file.delete();
		return unloaded;
		
	}
}
